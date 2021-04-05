var DisplayHide = /** @class */ (function () {
    function DisplayHide() {
        this.hide = function (idName) {
            document.getElementById(idName).setAttribute("style", "display:none ");
        };
        this.display = function (idName) {
            document.getElementById(idName).setAttribute("style", "display:block ");
        };
    }
    return DisplayHide;
}());
