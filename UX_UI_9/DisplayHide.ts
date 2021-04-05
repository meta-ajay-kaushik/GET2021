class DisplayHide {
  hide:Function = (idName:string) => {
    document.getElementById(idName).setAttribute("style", "display:none ");
  };

  display:Function = (idName:string) => {
    document.getElementById(idName).setAttribute("style", "display:block ");
  };
}
