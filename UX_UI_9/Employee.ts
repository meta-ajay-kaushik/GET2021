class Employee {
  name: string;
  password: string;
  id: number;
  dh = new DisplayHide();
  fname = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    if (key == 13) {
      if (item.value.length > 0) {
        if (
          item.value.search(/[!@#$%^&*]+/) == -1 &&
          item.value.search(/[0-9]+/) == -1 &&
          item.value.length >= 2
        ) {
          item.style = "border:2px solid blue ";
          document.getElementById("error").innerHTML = " ";
          this.name = item.value;
          item.style = "display:none ";
          this.dh.display("gen");
          document.getElementById(
            "message"
          ).innerHTML = `Hi ${this.name}, please enter your gender`;
        } else {
          item.style = "border:2px solid red ";
          document.getElementById("error").innerHTML =
            "Name must be >=2 characters and have only alphabets";
        }
      } else {
        item.style = "border:2px solid red ";
        document.getElementById("error").innerHTML = "please enter the name";
      }
    }
  };

  fgender = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    document.getElementById(
      "message"
    ).innerHTML = `Hi ${this.name}, please enter your email`;
    this.dh.hide("gen");
    this.dh.display("email");
  };

  femail = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    if (key == 13) {
      if (item.value.length > 0) {
        if (item.value.search(/[a-zA-Z0-9]+[@]+[a-zA-Z]+[.]+[a-zA-Z]/) != -1) {
          item.style = "border:2px solid blue ";
          document.getElementById("error").innerHTML = " ";
          item.style = "display:none ";
          this.dh.display("password");
          document.getElementById(
            "message"
          ).innerHTML = `Hi ${this.name}, create your password `;
        } else {
          item.style = "border:2px solid red ";
          document.getElementById("error").innerHTML =
            "please enter valid email ";
        }
      } else {
        item.style = "border:2px solid red ";
        document.getElementById("error").innerHTML = "please enter the email ";
      }
    }
  };

  fpassword = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    if (
      item.value.search(/[0-9]+/) != -1 &&
      item.value.search(/[!@#$%^&*(){}?><]+/) != -1 &&
      item.value.search(/[A-Z]+/) != -1 &&
      item.value.length >= 8
    ) {
      item.style = "border:2px solid green";
    } else if (
      item.value.search(/[0-9]+/) != -1 &&
      item.value.search(/[A-Z]+/) != -1 &&
      item.value.length >= 8
    ) {
      item.style = "border:2px solid orange";
    } else {
      item.style = "border:2px solid black";
    }
    if (key == 13) {
      if (item.value.length > 0) {
        if (
          item.value.search(/[0-9]+/) != -1 &&
          item.value.search(/[!@#$%^&*(){}?><]+/) != -1 &&
          item.value.search(/[A-Z]+/) != -1 &&
          item.value.length >= 8
        ) {
          item.style = "border:2px solid blue ";
          document.getElementById("error").innerHTML = " ";
          this.password = item.value;
          item.style = "display:none ";
          this.dh.display("confirmPassword");
          document.getElementById(
            "message"
          ).innerHTML = `Hi ${this.name}, confirm your password `;
        } else {
          item.style = "border:2px solid red ";
          document.getElementById("error").innerHTML =
            "password must be >=8 characters and also have any special character, and number ";
        }
      } else {
        item.style = "border:2px solid red ";
        document.getElementById("error").innerHTML =
          "please enter the password ";
      }
    }
  };

  fconfirmPassword = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    if (key == 13) {
      if (item.value.length > 0) {
        if (this.password == item.value) {
          item.style = "border:2px solid blue ";
          document.getElementById("error").innerHTML = " ";
          item.style = "display:none ";
          document
            .getElementById("contact")
            .setAttribute("style", "display:block");
          this.dh.display("contact");
          document.getElementById(
            "message"
          ).innerHTML = `Hi ${this.name}, enter contact number `;
        } else {
          document.getElementById("error").innerHTML = " password not matched";
        }
      } else {
        item.style = "border:2px solid red ";
        document.getElementById("error").innerHTML =
          "please enter the password ";
      }
    }
  };

  fcontact = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    if (key == 13) {
      if (item.value.length > 0) {
        let pattern = new RegExp("[789][0-9]{9}$");
        if (pattern.test(item.value) && item.value.length > 8) {
          item.style = "border:2px solid blue ";
          document.getElementById("error").innerHTML = " ";
          item.style = "display:none ";
          this.dh.display("company");
          document.getElementById(
            "message"
          ).innerHTML = `Hi ${this.name}, please add vehicle details`;
        } else {
          item.style = "border:2px solid red ";
          document.getElementById("error").innerHTML =
            "please enter valid contact number ";
        }
      } else {
        item.style = "border:2px solid red ";
        document.getElementById("error").innerHTML =
          "please enter the contact number ";
      }
    }
  };
}
