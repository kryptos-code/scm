// FETCH ACTIVE THEME [Light by default]
let currentTheme = getTheme();

document.addEventListener('DOMContentLoaded', ()=>{
    changeTheme();  
});

// Changing webpage theme
function changeTheme(){

    // if theme is dark then set light else dark - Set listener
    const changeThemeButton = document.querySelector("#change_theme_button");
    
    themeButton(currentTheme, changeThemeButton);
    
    changeThemeButton.addEventListener("click", (event)=>{
        
        document.querySelector("html").classList.remove(currentTheme);

        if (currentTheme === "dark"){
            currentTheme="light";
        }  else{
            currentTheme="dark";
        } 

        // Change button's value as per theme
        themeButton(currentTheme, changeThemeButton);
        console.log("Successfully! Theme Changed.");

    });
}

// setTheme
function setTheme(theme) {
    localStorage.setItem("theme",theme);
}

function getTheme() {
    let theme = localStorage.getItem("theme");
    return theme ? theme : "light";
}

function themeButton(theme, changeThemeButton){
    // Setting theme into attribute
    setTheme(theme);
    
    // Change webpage theme
    document.querySelector("html").classList.add(theme);

    // Change Icon
    if(theme=== "dark"){
        changeThemeButton.querySelector("i").classList.remove("fa-moon"); 
        changeThemeButton.querySelector("i").classList.add("fa-sun"); 

    }else {
        changeThemeButton.querySelector("i").classList.remove("fa-sun");
        changeThemeButton.querySelector("i").classList.add("fa-moon");

    }
    // Change Text
    changeThemeButton.querySelector("span").textContent = (currentTheme==="light" ? "dark" : "light");
}
