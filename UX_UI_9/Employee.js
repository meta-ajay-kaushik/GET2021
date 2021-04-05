var Employee = /** @class */ (function () {
    function Employee() {
        var _this = this;
        this.dh = new DisplayHide();
        this.fname = function (item, event) {
            var key = event.keyCode;
            if (key == 13) {
                if (item.value.length > 0) {
                    if (item.value.search(/[!@#$%^&*]+/) == -1 &&
                        item.value.search(/[0-9]+/) == -1 &&
                        item.value.length >= 2) {
                        item.style = "border:2px solid blue ";
                        document.getElementById("error").innerHTML = " ";
                        _this.name = item.value;
                        item.style = "display:none ";
                        _this.dh.display("gen");
                        document.getElementById("message").innerHTML = "Hi " + _this.name + ", please enter your gender";
                    }
                    else {
                        item.style = "border:2px solid red ";
                        document.getElementById("error").innerHTML =
                            "Name must be >=2 characters and have only alphabets";
                    }
                }
                else {
                    item.style = "border:2px solid red ";
                    document.getElementById("error").innerHTML = "please enter the name";
                }
            }
        };
        this.fgender = function (item, event) {
            var key = event.keyCode;
            document.getElementById("message").innerHTML = "Hi " + _this.name + ", please enter your email";
            _this.dh.hide("gen");
            _this.dh.display("email");
        };
        this.femail = function (item, event) {
            var key = event.keyCode;
            if (key == 13) {
                if (item.value.length > 0) {
                    if (item.value.search(/[a-zA-Z0-9]+[@]+[a-zA-Z]+[.]+[a-zA-Z]/) != -1) {
                        item.style = "border:2px solid blue ";
                        document.getElementById("error").innerHTML = " ";
                        item.style = "display:none ";
                        _this.dh.display("password");
                        document.getElementById("message").innerHTML = "Hi " + _this.name + ", create your password ";
                    }
                    else {
                        item.style = "border:2px solid red ";
                        document.getElementById("error").innerHTML =
                            "please enter valid email ";
                    }
                }
                else {
                    item.style = "border:2px solid red ";
                    document.getElementById("error").innerHTML = "please enter the email ";
                }
            }
        };
        this.fpassword = function (item, event) {
            var key = event.keyCode;
            if (item.value.search(/[0-9]+/) != -1 &&
                item.value.search(/[!@#$%^&*(){}?><]+/) != -1 &&
                item.value.search(/[A-Z]+/) != -1 &&
                item.value.length >= 8) {
                item.style = "border:2px solid green";
            }
            else if (item.value.search(/[0-9]+/) != -1 &&
                item.value.search(/[A-Z]+/) != -1 &&
                item.value.length >= 8) {
                item.style = "border:2px solid orange";
            }
            else {
                item.style = "border:2px solid black";
            }
            if (key == 13) {
                if (item.value.length > 0) {
                    if (item.value.search(/[0-9]+/) != -1 &&
                        item.value.search(/[!@#$%^&*(){}?><]+/) != -1 &&
                        item.value.search(/[A-Z]+/) != -1 &&
                        item.value.length >= 8) {
                        item.style = "border:2px solid blue ";
                        document.getElementById("error").innerHTML = " ";
                        _this.password = item.value;
                        item.style = "display:none ";
                        _this.dh.display("confirmPassword");
                        document.getElementById("message").innerHTML = "Hi " + _this.name + ", confirm your password ";
                    }
                    else {
                        item.style = "border:2px solid red ";
                        document.getElementById("error").innerHTML =
                            "password must be >=8 characters and also have any special character, and number ";
                    }
                }
                else {
                    item.style = "border:2px solid red ";
                    document.getElementById("error").innerHTML =
                        "please enter the password ";
                }
            }
        };
        this.fconfirmPassword = function (item, event) {
            var key = event.keyCode;
            if (key == 13) {
                if (item.value.length > 0) {
                    if (_this.password == item.value) {
                        item.style = "border:2px solid blue ";
                        document.getElementById("error").innerHTML = " ";
                        item.style = "display:none ";
                        document
                            .getElementById("contact")
                            .setAttribute("style", "display:block");
                        _this.dh.display("contact");
                        document.getElementById("message").innerHTML = "Hi " + _this.name + ", enter contact number ";
                    }
                    else {
                        document.getElementById("error").innerHTML = " password not matched";
                    }
                }
                else {
                    item.style = "border:2px solid red ";
                    document.getElementById("error").innerHTML =
                        "please enter the password ";
                }
            }
        };
        this.fcontact = function (item, event) {
            var key = event.keyCode;
            if (key == 13) {
                if (item.value.length > 0) {
                    var pattern = new RegExp("[789][0-9]{9}$");
                    if (pattern.test(item.value) && item.value.length > 8) {
                        item.style = "border:2px solid blue ";
                        document.getElementById("error").innerHTML = " ";
                        item.style = "display:none ";
                        _this.dh.display("company");
                        document.getElementById("message").innerHTML = "Hi " + _this.name + ", please add vehicle details";
                    }
                    else {
                        item.style = "border:2px solid red ";
                        document.getElementById("error").innerHTML =
                            "please enter valid contact number ";
                    }
                }
                else {
                    item.style = "border:2px solid red ";
                    document.getElementById("error").innerHTML =
                        "please enter the contact number ";
                }
            }
        };
    }
    return Employee;
}());
