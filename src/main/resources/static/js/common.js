let header = document.getElementById("header")
window.addEventListener('scroll', () => {
    if (window.scrollY > 0) {
        header.style.display = 'none'
    } else {
        header.style.display = 'block'
    }
})