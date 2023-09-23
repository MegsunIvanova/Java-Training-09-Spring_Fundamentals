// =================
//  1.  Sort Array
// =================
console.log("==== 1.  Sort Array ====")

function sortArray(arr, order) {
    let sortNumbers = (a, b) => a - b
    if (order === "asc") {
        return arr.sort(sortNumbers)
    } else if (order === "desc") {
        return arr.sort(sortNumbers).reverse()
    }
}

console.log(sortArray([14, 7, 17, 6, 8], "asc"))
console.log(sortArray([14, 7, 17, 6, 8], "desc"))

console.log("");
// =================
//  2.  Argument Info
// =================
console.log("==== 2.  Argument Info ====")

function argumentInfo() {
    let values = Object.values(arguments)
    let countByTypes = []
    for (const arg of values) {
        let type = typeof arg;
        console.log(type + " : " + arg)

        let typeElement = countByTypes.find(el => el[0] === type);
        if (typeElement) {
            typeElement[1] += 1;
        } else {
            countByTypes.push([type, 1])
        }
    }

    countByTypes.sort((a, b) => b[1] - a[1])
        .forEach(el => console.log(el[0] + " = " + el[1]))
}

argumentInfo('cat', 42, function () {
    console.log('Hello world!');
})

console.log("");
// =================
//  3. Personal BMI
// =================
console.log("==== 3. Personal BMI ====")

function personalBMI(name, age, weight, height) {
    let personalInfo = {age, weight, height}
    let heightMeters = height / 100;
    let bmi = weight / (heightMeters * heightMeters)
    let patient = {name, personalInfo}
    patient['BMI'] = bmi.toFixed(0)

    let status
    if (bmi < 18.5) {
        status = "underweight"
    } else if (bmi < 25) {
        status = "normal"
    } else if (bmi < 30) {
        status = "overweight"
    } else {
        status = "obese"
    }

    patient[status] = status
    if (status === "obese") {
        patient["recommendation"] = "admission required"
    }

    return patient;
}

console.log(personalBMI("Peter", 29, 75, 182))
console.log(personalBMI("Honey Boo Boo", 9, 57, 137))

console.log("");
// =================
//  4. Heroic Inventory
// =================
console.log("==== 4. Heroic Inventory ====")

function heroicInventory(data) {
    let heroes = []
    for (const line of data) {
        let tokens = line.split(" / ");
        let hero = {
            name: tokens[0],
            level: +tokens[1],
            items: tokens[2].split(", ")
        }

        heroes.push(hero)
    }

    return JSON.stringify(heroes);
}

console.log(heroicInventory(
    ['Isacc / 25 / Apple, GravityGun',
        'Derek / 12 / BarrelVest, DestructionSword',
        'Hes / 1 / Desolator, Sentinel, Antara']
))

console.log(heroicInventory(
    ['Jake / 1000 / Gauss, HolidayGrenade']
))

console.log("");
// =================
//  5. JSON's Table
// =================
console.log("==== 5. JSON's Table ====")

function jsonTable(input) {
    let data = JSON.parse(input);

}

console.log(jsonTable(
    ['{"name":"Pesho","position":"Promenliva","salary":100000}',
        '{"name":"Teo","position":"Lecturer","salary":1000}',
        '{"name":"Georgi","position":"Lecturer","salary":1000}']
))