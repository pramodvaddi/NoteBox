const API = "/api/notes";

document.getElementById("noteForm").addEventListener("submit", e => {
    e.preventDefault();

    fetch(API, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            title: title.value,
            content: content.value
        })
    }).then(() => {
        noteForm.reset();
        loadNotes();
    });
});

function loadNotes() {
    fetch(API)
        .then(res => res.json())
        .then(data => {
            notes.innerHTML = "";
            data.content.forEach(n => {
                notes.innerHTML += `
                    <div class="note">
                        <b>${n.title}</b>
                        <p>${n.content}</p>
                        <button onclick="deleteNote(${n.id})">Delete</button>
                    </div>`;
            });
        });
}

function deleteNote(id) {
    fetch(`${API}/${id}`, { method: "DELETE" })
        .then(() => loadNotes());
}
