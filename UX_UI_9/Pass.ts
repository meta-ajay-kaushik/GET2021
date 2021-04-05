class Pass extends Vehicle {
  dh = new DisplayHide();
  currencyTypeChange = (item) => {
    let currency = item.value;
    if (currency == "INR") {
      if (this.vehicle == "Cycle") {
        document.getElementById("passCost").setAttribute("value", "0.07 $");
        document.getElementById("dailyPass").innerHTML = "Daily Parking 5 RS";
        document.getElementById("monthlyPass").innerHTML =
          "Monthly Parking 100 RS";
        document.getElementById("yearlyPass").innerHTML =
          "Yearly Parking 500 RS";
      } else if (this.vehicle == "Motor Cycle") {
        document.getElementById("passCost").setAttribute("value", "0.14 $");
        document.getElementById("dailyPass").innerHTML = "Daily Parking 10 RS";
        document.getElementById("monthlyPass").innerHTML =
          "Monthly Parking 200 RS";
        document.getElementById("yearlyPass").innerHTML =
          "Yearly Parking 1000 RS";
      } else if (this.vehicle == "Four Wheeler") {
        document.getElementById("passCost").setAttribute("value", "0.28 $");
        document.getElementById("dailyPass").innerHTML = "Daily Parking 20 RS";
        document.getElementById("monthlyPass").innerHTML =
          "Monthly Parking 500 RS";
        document.getElementById("yearlyPass").innerHTML =
          "Yearly Parking 3500 RS";
      }
    } else if (currency == "USD") {
      if (this.vehicle == "Cycle") {
        document.getElementById("passCost").setAttribute("value", "0.07 $");
        document.getElementById("dailyPass").innerHTML = "Daily Parking 0.07 $";
        document.getElementById("monthlyPass").innerHTML =
          "Monthly Parking 1.4 $";
        document.getElementById("yearlyPass").innerHTML =
          "Yearly Parking 7.0 $";
      } else if (this.vehicle == "Motor Cycle") {
        document.getElementById("passCost").setAttribute("value", "0.14 $");
        document.getElementById("dailyPass").innerHTML = "Daily Parking 0.14 $";
        document.getElementById("monthlyPass").innerHTML =
          "Monthly Parking 2.8 $";
        document.getElementById("yearlyPass").innerHTML =
          "Yearly Parking 14.0 $";
      } else if (this.vehicle == "Four Wheeler") {
        document.getElementById("passCost").setAttribute("value", "0.28 $");
        document.getElementById("dailyPass").innerHTML = "Daily Parking 0.28 $";
        document.getElementById("monthlyPass").innerHTML =
          "Monthly Parking 7.14 $";
        document.getElementById("yearlyPass").innerHTML = "Yearly Parking 50$";
      }
    } else if (currency == "YEN") {
      if (this.vehicle == "Cycle") {
        document.getElementById("passCost").setAttribute("value", " 0.07 $");
        document.getElementById("dailyPass").innerHTML = "Daily Parking 7 YEN";
        document.getElementById("monthlyPass").innerHTML =
          "Monthly Parking 150 YEN";
        document.getElementById("yearlyPass").innerHTML =
          "Yearly Parking 1500 YEN";
      } else if (this.vehicle == "Motor Cycle") {
        document.getElementById("passCost").setAttribute("value", "0.14 $");
        document.getElementById("dailyPass").innerHTML = "Daily Parking 14 YEN";
        document.getElementById("monthlyPass").innerHTML =
          "Monthly Parking 300 YEN";
        document.getElementById("yearlyPass").innerHTML =
          "Yearly Parking 3000 YEN";
      } else if (this.vehicle == "Four Wheeler") {
        document.getElementById("passCost").setAttribute("value", "0.28 $");
        document.getElementById("dailyPass").innerHTML = "Daily Parking 30 YEN";
        document.getElementById("monthlyPass").innerHTML =
          "Monthly Parking 750 YEN";
        document.getElementById("yearlyPass").innerHTML =
          "Yearly Parking 5250 YEN";
      }
    }
    document.getElementById(
      "message"
    ).innerHTML = `Hi ${this.name}, choose your plan `;
    this.dh.hide("selectCurrency");
    this.dh.display("selectPass");
  };

  passTypeChange = (item) => {
    let x = item.selectedIndex;
    if (x == 1) {
      if (this.vehicle == "Cycle") {
        document.getElementById("passCost").setAttribute("value", "0.07 $");
      } else if (this.vehicle == "Motor Cycle") {
        document.getElementById("passCost").setAttribute("value", "0.14 $");
      } else if (this.vehicle == "Four Wheeler") {
        document.getElementById("passCost").setAttribute("value", "0.28 $");
      }
    } else if (x == 2) {
      if (this.vehicle == "Cycle") {
        document.getElementById("passCost").setAttribute("value", "1.4 $");
      } else if (this.vehicle == "Motor Cycle") {
        document.getElementById("passCost").setAttribute("value", "2.8 $");
      } else if (this.vehicle == "Four Wheeler") {
        document.getElementById("passCost").setAttribute("value", "7.14 $");
      }
    } else if (x == 3) {
      if (this.vehicle == "Cycle") {
        document.getElementById("passCost").setAttribute("value", "7 $");
      } else if (this.vehicle == "Motor Cycle") {
        document.getElementById("passCost").setAttribute("value", "14 $");
      } else if (this.vehicle == "Four Wheeler") {
        document.getElementById("passCost").setAttribute("value", "50 $");
      }
    }
    document.getElementById("message").innerHTML = `Hi ${
      this.name
    }, Please Pay ${document.getElementById("passCost").getAttribute("value")}`;
    this.dh.hide("selectPass");
    this.dh.display("submitfinal");
  };

  successful = () => {
    alert(`Thank you for registration your employee id is ${this.id}`);
    this.dh.hide("message");
    this.dh.hide("submitfinal");
    this.dh.hide("headingofemployeeregistration");
  };
}
