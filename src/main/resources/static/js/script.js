const btn = document.getElementById("search-button");
btn.addEventListener("click", clickHandler);

function clickHandler() {
    const input = document.getElementById("search-input").value;
    if (input.trim() !== "") {
        const encodedInput = encodeURIComponent(input);
        window.location.href = `/match/${encodedInput}`;
    } else {
        alert("검색어를 입력하세요.");
    }
}
