class DisplayHide {
  hide = (idName) => {
    document.getElementById(idName).setAttribute("style", "display:none ");
  };

  display = (idName) => {
    document.getElementById(idName).setAttribute("style", "display:block ");
  };
}
