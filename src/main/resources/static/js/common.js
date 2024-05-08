console.log("Hello from common");

// light theme as default
let currentTheme = getTheme();
changeTheme();

// changeTheme
function changeTheme(){

    // set to webpage
    document.querySelector("html").classList.add(currentTheme);

    // fetch the currentTheme
    const oldTheme = currentTheme;

    // if theme is dark then set light else dark - Set listener
    const changeThemeButton = document.querySelector("#change_theme_button");
    console.log(oldTheme);
    changeThemeButton.addEventListener("click", (event)=>{
        console.log("Button clicked");
        if (currentTheme === "dark"){
            console.log("Theme set to light");
            currentTheme="light";
        } 
        else{
            currentTheme="dark";
        } 

        setTheme(currentTheme);
        console.log(currentTheme);
        document.querySelector("html").classList.remove(oldTheme);
        document.querySelector("html").classList.add(currentTheme);
        
        // Change button's value as per theme
        if(currentTheme=== "dark"){
            changeThemeButton.querySelector("i").classList.remove("fa-moon"); 
            changeThemeButton.querySelector("i").classList.add("fa-sun"); 
    
        }else {
            changeThemeButton.querySelector("i").classList.remove("fa-sun");
            changeThemeButton.querySelector("i").classList.add("fa-moon");
    
        }

        changeThemeButton.querySelector("span").textContent = (currentTheme==="light" ? "dark" : "light");

    });


    // remove current theme from class

    // add new theme in class
}

// setTheme
function setTheme(theme) {
    localStorage.setItem("theme",theme);
}

function getTheme() {
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}

