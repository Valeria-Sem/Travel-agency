// (function () {
//     'use strict'
//
//     // Получите все формы, к которым мы хотим применить пользовательские стили проверки Bootstrap
//     var forms = document.querySelectorAll('.needs-validation')
//
//     // Зацикливайтесь на них и предотвращайте отправку
//     Array.prototype.slice.call(forms)
//         .forEach(function (form) {
//             form.addEventListener('submit', function (event) {
//                 if (!form.checkValidity()) {
//                     event.preventDefault()
//                     event.stopPropagation()
//                 }
//
//                 form.classList.add('was-validated')
//             }, false)
//         })
// })()

var email = document.getElementById("email");

if(email){
    email.addEventListener("input", function (event) {
        if (email.validity.typeMismatch) {
            email.setCustomValidity("I expect an e-mail, darling!");
        } else {
            email.setCustomValidity("");
        }
    }, false);
}

function register() {
    location.href = 'controller?command=registration';
    alert('Пользователь успешно добавлен');

}

