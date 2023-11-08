package com.example.coding.relaciones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.coding.relaciones.models.Category;
import com.example.coding.relaciones.models.CategoryProduct;
import com.example.coding.relaciones.models.Product;
import com.example.coding.relaciones.services.CategoryProductService;
import com.example.coding.relaciones.services.CategoryService;
import com.example.coding.relaciones.services.ProductService;

@Controller
public class CategoryProductController {
    private ProductService productService;
	private CategoryService categoryService;
	private CategoryProductService categoryProductService;

    public CategoryProductController(ProductService productService, CategoryService categoryService, CategoryProductService categoryProductService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.categoryProductService = categoryProductService;
    }

    // Ruta principal "/", redirige a "/products/new"
    @GetMapping("/")
    public String notHere() {
        return "redirect:/products/new";
    }

    // Es una vista para agregar un nuevo producto, muestra el formulario para crear un producto
    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "view/Product.jsp";
    }

    // Procesa y guarda los productos
    @PostMapping("/products/new")
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "view/Product.jsp"; // Si hay errores de validación, se muestra la vista de nuevo
        } else {
            // Buscar si ya existe un producto con el mismo nombre
            Product existingProduct = productService.findProductByName(product.getName());
            if (existingProduct != null) {
                // Si ya existe, muestra un mensaje de error en el modelo
                model.addAttribute("productAlreadyExistsError", "Product with the same name already exists.");
                return "view/Product.jsp";
            } else {
                productService.addProduct(product); // Guarda el producto en la base de datos
                return "redirect:/categories/new"; // Redirige a la vista para agregar una nueva categoría
            }
        }
    }

    // Es la muestra para agregar una nueva categoría, muestra el formulario para crear una categoría
    @GetMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "view/Category.jsp";
    }

    // Nueva mente hacemos que guarde, pero en este caso la categoria
    @PostMapping("/categories/new")
    public String addCategory(@ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "view/Category"; // Si hay errores de validación, se muestra la vista de nuevo
        } else {
            // Buscar si ya existe una categoría con el mismo nombre
            Category existingCategory = categoryService.findCategoryByName(category.getName());
            if (existingCategory != null) {
                // Si ya existe, muestra un mensaje de error en el modelo
            	model.addAttribute("categoryAlreadyExistsError", "Category with the same name already exists.");
                return "view/Category";
            } else {
                categoryService.addCategory(category); // Guarda la categoría en la base de datos
                return "redirect:/products/new"; // Redirige a la vista para agregar un nuevo producto
            }
        }
    }

    // Vista para asociar una categoría a un producto, muestra el formulario para seleccionar una categoría
    // y mostrar las categorías disponibles para asociar con el producto
    @GetMapping("/products/{productId}")
    public String productAddCategory(
            @ModelAttribute("categoryProduct") CategoryProduct categoryProduct,
            @PathVariable("productId") Long id,
            Model model
    ) {
        // Agrega el producto y las categorías disponibles al modelo
        model.addAttribute("product", productService.findProductById(id));
        model.addAttribute("categories", categoryService.allExcludeCategories(productService.findProductById(id)));

        return "view/productPage.jsp";
    }

    // Se asocia una categoria a un producto y se guarda
    @PostMapping("/products/{productId}")
    public String addCategoryToProduct(
            @PathVariable("productId") Long Id,
            @ModelAttribute("categoryProduct") CategoryProduct categoryProduct,
            BindingResult result // Es una clase que almacena errores, osea es una forma de obtener información sobre los errores de validación del objeto CategoryProduct
    ) {
        categoryProduct.setProduct(productService.findProductById(Id)); // Establece el producto seleccionado
        categoryProductService.joinCategoryToProduct(categoryProduct); // Guarda  en la base de datos
        return "redirect:/products/" + Id; // Redirige a la vista de detalles del producto
    }

    // Vista para asociar un producto a una categoría, muestra el formulario para seleccionar un producto
    // y mostrar los productos disponibles para asociar con la categoría
    @GetMapping("categories/{categoryId}")
    public String categoryAddProduct(
            @ModelAttribute("categoryProduct") CategoryProduct categoryProduct,
            @PathVariable("categoryId") Long id,
            Model model
    ) {
        // Agrega la categoría y los productos disponibles al modelo
        model.addAttribute("products", productService.allExcludeProducts(categoryService.findCategoryById(id)));
        model.addAttribute("category", categoryService.findCategoryById(id));

        return "view/categoryPage.jsp";
    }

    // Se asocia un producto a una categoria y se guarda
    @PostMapping("categories/{categoryId}")
    public String addProductToCategory(
            @ModelAttribute("categoryProduct") CategoryProduct categoryProduct,
            @PathVariable("categoryId") Long id,
            Model model
    ) {
        categoryProduct.setCategory(categoryService.findCategoryById(id)); // Establece la categoría seleccionada
        categoryProductService.joinCategoryToProduct(categoryProduct); // Guarda en la base de datos
        return "redirect:/categories/" + id; // Redirige a la vista de detalles de la categoría
    }
}
