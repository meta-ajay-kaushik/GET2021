class Vehicle extends Employee {
  vehicle: string;
  dh = new DisplayHide();
  fvehicleCompany = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    if (key == 13) {
      if (item.value.length > 0) {
        if (
          item.value.search(/[!@#$%^&*]+/) == -1 &&
          item.value.search(/[0-9]+/) == -1
        ) {
          item.style = "border:2px solid blue ";
          document.getElementById("error").innerHTML = " ";
          item.style = "display:none ";
          this.dh.display("model");
          document.getElementById(
            "message"
          ).innerHTML = `Hi ${this.name}, enter your vehicle model `;
        } else {
          item.style = "border:2px solid red ";
          document.getElementById("error").innerHTML =
            "please enter valid vehicle company Name ";
        }
      } else {
        item.style = "border:2px solid red ";
        document.getElementById("error").innerHTML =
          "please enter the company name ";
      }
    }
  };

  fvehicleType = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    document.getElementById("error").innerHTML = " ";
    item.style = "display:none ";
    this.dh.display("number");
    this.vehicle = item.value;
    document.getElementById(
      "message"
    ).innerHTML = `Hi ${this.name}, enter your vehicle number `;
  };

  fvehicleModel = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    if (key == 13) {
      if (item.value.length > 0) {
        if (item.value.length > 2) {
          item.style = "border:2px solid blue ";
          document.getElementById("error").innerHTML = " ";
          item.style = "display:none ";
          this.dh.display("type");
          document.getElementById(
            "message"
          ).innerHTML = `Hi ${this.name}, select your vehicle type `;
        } else {
          item.style = "border:2px solid red ";
          document.getElementById("error").innerHTML =
            "please enter valid vehicle Model more than 2 characters ";
        }
      } else {
        item.style = "border:2px solid red ";
        document.getElementById("error").innerHTML =
          "please enter the vehicle model ";
      }
    }
  };

  fvehicleNumber = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    if (key == 13) {
      if (item.value.length > 0) {
        let pattern = new RegExp("[A-Za-z]{2}[0-9]{2}[A-Za-z]{2}[0-9]{4}");
        if (item.value.length > 4 && pattern.test(item.value)) {
          item.style = "border:2px solid blue ";
          document.getElementById("error").innerHTML = " ";
          item.style = "display:none ";
          this.dh.display("empid");
          document.getElementById(
            "message"
          ).innerHTML = `Hi ${this.name}, Enter your Employee ID `;
        } else {
          item.style = "border:2px solid red ";
          document.getElementById("error").innerHTML =
            'please enter valid vehicle number like "RJ14GJ4509" ';
        }
      } else {
        item.style = "border:2px solid red ";
        document.getElementById("error").innerHTML =
          "please enter the vehicle number ";
      }
    }
  };
  fid = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    if (key == 13) {
      if (item.value.length > 0) {
        item.style = "border:2px solid blue ";
        document.getElementById("error").innerHTML = " ";
        item.style = "display:none ";
        this.dh.display("identification");
        this.id = item.value;
        document.getElementById(
          "message"
        ).innerHTML = `Hi ${this.name}, more about vehicle `;
      } else {
        item.style = "border:2px solid red ";
        document.getElementById("error").innerHTML =
          "please enter Employee ID ";
      }
    }
  };

  fvehicleIdentication = (item, event: KeyboardEvent) => {
    let key = event.keyCode;
    if (key == 13) {
      if (item.value.length > 0) {
        if (item.value.length > 4) {
          item.style = "border:2px solid blue ";
          document.getElementById("error").innerHTML = " ";
          item.style = "display:none ";
          this.dh.display("selectCurrency");
          document.getElementById(
            "message"
          ).innerHTML = `Hi ${this.name}, select currency to Pay `;
        } else {
          item.style = "border:2px solid red ";
          document.getElementById("error").innerHTML =
            "please enter valid vehicle identifications more than 4 characters";
        }
      } else {
        item.style = "border:2px solid red ";
        document.getElementById("error").innerHTML = "please enter the value ";
      }
    }
  };
}
