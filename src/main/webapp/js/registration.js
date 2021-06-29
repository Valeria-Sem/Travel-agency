// let regBtn = document.getElementById("regBtn");


// function toRegister(form) {
//     let email = document.getElementById('input[id$=email]');
//     let password = document.getElementById('input[id$=password]');
//     let name = document.getElementById('input[id$=name]');
//     let surname = document.getElementById('input[id$=surname]');
//     let date1 = document.getElementById('input[id$=datepicker]');
//     let passport = document.getElementById('input[id$=passport]');
//     let nationality = document.getElementById('input[id$=nationality]');
//     let date2 = document.getElementById('input[id$=datepicker2]');
//     let date3 = document.getElementById('input[id$=datepicker3]');
//     let result = true
//
//     if (result) {
//         form.submit()
//     }
// }

// function register(event) {
//     event.preventDefault();
//     window.location.replace("controller?command=registration")
//     alert('Пользователь успешно добавлен');
//
// }
//
// regBtn.addEventListener("click", register);

function onHidden() {
    event.preventDefault();
    console.log('Dropdown is hidden');

}

function onShown() {
    event.preventDefault();
    console.log('Dropdown is shown');

}

function isOpenChange() {
    event.preventDefault();
    console.log('Dropdown state is changed');
}
