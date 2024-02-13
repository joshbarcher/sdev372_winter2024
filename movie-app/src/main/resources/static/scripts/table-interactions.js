//wait until the page loads
window.onload = function() {
    //select all edit links
    const editLinks = document.querySelectorAll('.edit');
    for (const link of editLinks) {
        link.onclick = editRecord;
    }
}

function editRecord(evt) {
    console.log(evt.target);
}