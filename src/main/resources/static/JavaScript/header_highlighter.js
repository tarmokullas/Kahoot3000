var headerlist = document.getElementsByClassName("header-link");
for (var i = 0; i < headerlist.length; i++) {
    if (headerlist.item(i).href == window.location.href) {
        console.log("bold");
        headerlist.item(i).innerHTML = "<b>" + headerlist.item(i).innerHTML + "</b>";
    }
}

