/**
 * 
 */
const carousel = document.getElementById("carousel");
const dotsContainer = document.getElementById("dots");
const images = carousel.querySelectorAll("img");
let currentIndex = 0;
const totalSlides = images.length;

// Create dots
for (let i = 0; i < totalSlides; i++) {
	const dot = document.createElement("span");
	dot.classList.add("carousel-dot");
	if (i === 0) dot.classList.add("active");
	dot.addEventListener("click", () => moveToSlide(i));
	dotsContainer.appendChild(dot);
}

const dots = document.querySelectorAll(".carousel-dot");

function updateDots(index) {
	dots.forEach((dot) => dot.classList.remove("active"));
	dots[index].classList.add("active");
}

function moveToSlide(index) {
	currentIndex = index;
	carousel.style.transform = `translateX(-${index * 100}vw)`;
	updateDots(index);
}

function autoSlide() {
	currentIndex = (currentIndex + 1) % totalSlides;
	moveToSlide(currentIndex);
}

let autoSlideInterval = setInterval(autoSlide, 1500);

// Pause on hover
carousel.addEventListener("mouseenter", () =>
	clearInterval(autoSlideInterval)
);
carousel.addEventListener(
	"mouseleave",
	() => (autoSlideInterval = setInterval(autoSlide, 1500))
);


