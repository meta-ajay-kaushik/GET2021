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
var Vehicle = /** @class */ (function (_super) {
    __extends(Vehicle, _super);
    function Vehicle() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.dh = new DisplayHide();
        _this.fvehicleCompany = function (item, event) {
            var key = event.keyCode;
            if (key == 13) {
                if (item.value.length > 0) {
                    if (item.value.search(/[!@#$%^&*]+/) == -1 &&
                        item.value.search(/[0-9]+/) == -1) {
                        item.style = "border:2px solid blue ";
                        document.getElementById("error").innerHTML = " ";
                        item.style = "display:none ";
                        _this.dh.display("model");
                        document.getElementById("message").innerHTML = "Hi " + _this.name + ", enter your vehicle model ";
                    }
                    else {
                        item.style = "border:2px solid red ";
                        document.getElementById("error").innerHTML =
                            "please enter valid vehicle company Name ";
                    }
                }
                else {
                    item.style = "border:2px solid red ";
                    document.getElementById("error").innerHTML =
                        "please enter the company name ";
                }
            }
        };
        _this.fvehicleType = function (item, event) {
            var key = event.keyCode;
            document.getElementById("error").innerHTML = " ";
            item.style = "display:none ";
            _this.dh.display("number");
            _this.vehicle = item.value;
            document.getElementById("message").innerHTML = "Hi " + _this.name + ", enter your vehicle number ";
        };
        _this.fvehicleModel = function (item, event) {
            var key = event.keyCode;
            if (key == 13) {
                if (item.value.length > 0) {
                    if (item.value.length > 2) {
                        item.style = "border:2px solid blue ";
                        document.getElementById("error").innerHTML = " ";
                        item.style = "display:none ";
                        _this.dh.display("type");
                        document.getElementById("message").innerHTML = "Hi " + _this.name + ", select your vehicle type ";
                    }
                    else {
                        item.style = "border:2px solid red ";
                        document.getElementById("error").innerHTML =
                            "please enter valid vehicle Model more than 2 characters ";
                    }
                }
                else {
                    item.style = "border:2px solid red ";
                    document.getElementById("error").innerHTML =
                        "please enter the vehicle model ";
                }
            }
        };
        _this.fvehicleNumber = function (item, event) {
            var key = event.keyCode;
            if (key == 13) {
                if (item.value.length > 0) {
                    var pattern = new RegExp("[A-Za-z]{2}[0-9]{2}[A-Za-z]{2}[0-9]{4}");
                    if (item.value.length > 4 && pattern.test(item.value)) {
                        item.style = "border:2px solid blue ";
                        document.getElementById("error").innerHTML = " ";
                        item.style = "display:none ";
                        _this.dh.display("empid");
                        document.getElementById("message").innerHTML = "Hi " + _this.name + ", Enter your Employee ID ";
                    }
                    else {
                        item.style = "border:2px solid red ";
                        document.getElementById("error").innerHTML =
                            'please enter valid vehicle number like "RJ14GJ4509" ';
                    }
                }
                else {
                    item.style = "border:2px solid red ";
                    document.getElementById("error").innerHTML =
                        "please enter the vehicle number ";
                }
            }
        };
        _this.fid = function (item, event) {
            var key = event.keyCode;
            if (key == 13) {
                if (item.value.length > 0) {
                    item.style = "border:2px solid blue ";
                    document.getElementById("error").innerHTML = " ";
                    item.style = "display:none ";
                    _this.dh.display("identification");
                    _this.id = item.value;
                    document.getElementById("message").innerHTML = "Hi " + _this.name + ", more about vehicle ";
                }
                else {
                    item.style = "border:2px solid red ";
                    document.getElementById("error").innerHTML =
                        "please enter Employee ID ";
                }
            }
        };
        _this.fvehicleIdentication = function (item, event) {
            var key = event.keyCode;
            if (key == 13) {
                if (item.value.length > 0) {
                    if (item.value.length > 4) {
                        item.style = "border:2px solid blue ";
                        document.getElementById("error").innerHTML = " ";
                        item.style = "display:none ";
                        _this.dh.display("selectCurrency");
                        document.getElementById("message").innerHTML = "Hi " + _this.name + ", select currency to Pay ";
                    }
                    else {
                        item.style = "border:2px solid red ";
                        document.getElementById("error").innerHTML =
                            "please enter valid vehicle identifications more than 4 characters";
                    }
                }
                else {
                    item.style = "border:2px solid red ";
                    document.getElementById("error").innerHTML = "please enter the value ";
                }
            }
        };
        return _this;
    }
    return Vehicle;
}(Employee));
