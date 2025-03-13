document.addEventListener("DOMContentLoaded", function () {
    const deleteButtons = document.querySelectorAll(".delete-btn");

    deleteButtons.forEach(button => {
        button.addEventListener("click", function (event) {
            if (!confirm("Tem certeza que deseja excluir este item?")) {
                event.preventDefault();
            }
        });
    });
});