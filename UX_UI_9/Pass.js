var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Pass = /** @class */ (function (_super) {
    __extends(Pass, _super);
    function Pass() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.dh = new DisplayHide();
        _this.currencyTypeChange = function (item) {
            var currency = item.value;
            if (currency == "INR") {
                if (_this.vehicle == "Cycle") {
                    document.getElementById("passCost").setAttribute("value", "0.07 $");
                    document.getElementById("dailyPass").innerHTML = "Daily Parking 5 RS";
                    document.getElementById("monthlyPass").innerHTML =
                        "Monthly Parking 100 RS";
                    document.getElementById("yearlyPass").innerHTML =
                        "Yearly Parking 500 RS";
                }
                else if (_this.vehicle == "Motor Cycle") {
                    document.getElementById("passCost").setAttribute("value", "0.14 $");
                    document.getElementById("dailyPass").innerHTML = "Daily Parking 10 RS";
                    document.getElementById("monthlyPass").innerHTML =
                        "Monthly Parking 200 RS";
                    document.getElementById("yearlyPass").innerHTML =
                        "Yearly Parking 1000 RS";
                }
                else if (_this.vehicle == "Four Wheeler") {
                    document.getElementById("passCost").setAttribute("value", "0.28 $");
                    document.getElementById("dailyPass").innerHTML = "Daily Parking 20 RS";
                    document.getElementById("monthlyPass").innerHTML =
                        "Monthly Parking 500 RS";
                    document.getElementById("yearlyPass").innerHTML =
                        "Yearly Parking 3500 RS";
                }
            }
            else if (currency == "USD") {
                if (_this.vehicle == "Cycle") {
                    document.getElementById("passCost").setAttribute("value", "0.07 $");
                    document.getElementById("dailyPass").innerHTML = "Daily Parking 0.07 $";
                    document.getElementById("monthlyPass").innerHTML =
                        "Monthly Parking 1.4 $";
                    document.getElementById("yearlyPass").innerHTML =
                        "Yearly Parking 7.0 $";
                }
                else if (_this.vehicle == "Motor Cycle") {
                    document.getElementById("passCost").setAttribute("value", "0.14 $");
                    document.getElementById("dailyPass").innerHTML = "Daily Parking 0.14 $";
                    document.getElementById("monthlyPass").innerHTML =
                        "Monthly Parking 2.8 $";
                    document.getElementById("yearlyPass").innerHTML =
                        "Yearly Parking 14.0 $";
                }
                else if (_this.vehicle == "Four Wheeler") {
                    document.getElementById("passCost").setAttribute("value", "0.28 $");
                    document.getElementById("dailyPass").innerHTML = "Daily Parking 0.28 $";
                    document.getElementById("monthlyPass").innerHTML =
                        "Monthly Parking 7.14 $";
                    document.getElementById("yearlyPass").innerHTML = "Yearly Parking 50$";
                }
            }
            else if (currency == "YEN") {
                if (_this.vehicle == "Cycle") {
                    document.getElementById("passCost").setAttribute("value", " 0.07 $");
                    document.getElementById("dailyPass").innerHTML = "Daily Parking 7 YEN";
                    document.getElementById("monthlyPass").innerHTML =
                        "Monthly Parking 150 YEN";
                    document.getElementById("yearlyPass").innerHTML =
                        "Yearly Parking 1500 YEN";
                }
                else if (_this.vehicle == "Motor Cycle") {
                    document.getElementById("passCost").setAttribute("value", "0.14 $");
                    document.getElementById("dailyPass").innerHTML = "Daily Parking 14 YEN";
                    document.getElementById("monthlyPass").innerHTML =
                        "Monthly Parking 300 YEN";
                    document.getElementById("yearlyPass").innerHTML =
                        "Yearly Parking 3000 YEN";
                }
                else if (_this.vehicle == "Four Wheeler") {
                    document.getElementById("passCost").setAttribute("value", "0.28 $");
                    document.getElementById("dailyPass").innerHTML = "Daily Parking 30 YEN";
                    document.getElementById("monthlyPass").innerHTML =
                        "Monthly Parking 750 YEN";
                    document.getElementById("yearlyPass").innerHTML =
                        "Yearly Parking 5250 YEN";
                }
            }
            document.getElementById("message").innerHTML = "Hi " + _this.name + ", choose your plan ";
            _this.dh.hide("selectCurrency");
            _this.dh.display("selectPass");
        };
        _this.passTypeChange = function (item) {
            var x = item.selectedIndex;
            if (x == 1) {
                if (_this.vehicle == "Cycle") {
                    document.getElementById("passCost").setAttribute("value", "0.07 $");
                }
                else if (_this.vehicle == "Motor Cycle") {
                    document.getElementById("passCost").setAttribute("value", "0.14 $");
                }
                else if (_this.vehicle == "Four Wheeler") {
                    document.getElementById("passCost").setAttribute("value", "0.28 $");
                }
            }
            else if (x == 2) {
                if (_this.vehicle == "Cycle") {
                    document.getElementById("passCost").setAttribute("value", "1.4 $");
                }
                else if (_this.vehicle == "Motor Cycle") {
                    document.getElementById("passCost").setAttribute("value", "2.8 $");
                }
                else if (_this.vehicle == "Four Wheeler") {
                    document.getElementById("passCost").setAttribute("value", "7.14 $");
                }
            }
            else if (x == 3) {
                if (_this.vehicle == "Cycle") {
                    document.getElementById("passCost").setAttribute("value", "7 $");
                }
                else if (_this.vehicle == "Motor Cycle") {
                    document.getElementById("passCost").setAttribute("value", "14 $");
                }
                else if (_this.vehicle == "Four Wheeler") {
                    document.getElementById("passCost").setAttribute("value", "50 $");
                }
            }
            document.getElementById("message").innerHTML = "Hi " + _this.name + ", Please Pay " + document.getElementById("passCost").getAttribute("value");
            _this.dh.hide("selectPass");
            _this.dh.display("submitfinal");
        };
        _this.successful = function () {
            alert("Thank you for registration your employee id is " + _this.id);
            _this.dh.hide("message");
            _this.dh.hide("submitfinal");
            _this.dh.hide("headingofemployeeregistration");
        };
        return _this;
    }
    return Pass;
}(Vehicle));
