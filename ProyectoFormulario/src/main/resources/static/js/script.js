/* Archivo script.js */
window.addEventListener('DOMContentLoaded', () => {
  const form = document.querySelector('form');
  form.addEventListener('submit', (event) => {
    const input = document.querySelector('input[name="fname"]');
    const errorMessage = document.querySelector('#error-message');
    if (input.value.toLowerCase() !== 'bushido') {
      event.preventDefault();
      errorMessage.innerHTML = '<h2>You must train harder!</h2>';
    }
  });
});
