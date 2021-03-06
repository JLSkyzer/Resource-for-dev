module.exports = {
    name: "Number 3x | Text 6x",

    description: "Creates 6 texts and 3 Numbers to use it in your blocks.",

    category: "Inputs",

    auto_execute: true,

    inputs: [],

    options: [
        {
            "id": "text1",
            "name": "Text 1",
            "description": "Description: The text to set.",
            "type": "TEXT"
        },
        {
            "id": "text2",
            "name": "Text 2",
            "description": "Description: The text to set.",
            "type": "TEXT"
        },
        {
            "id": "text3",
            "name": "Text 3",
            "description": "Description: The text to set.",
            "type": "TEXT"
        },
        {
            "id": "text4",
            "name": "Text 4",
            "description": "Description: The text to set.",
            "type": "TEXT"
        },
        {
            "id": "text5",
            "name": "Text 5",
            "description": "Description: The text to set.",
            "type": "TEXT"
        },
        {
            "id": "text6",
            "name": "Text 6",
            "description": "Description: The text to set.",
            "type": "TEXT"
        },
        {
            "id": "number1",
            "name": "number1",
            "description": "Description: The number to set.",
            "type": "NUMBER"
        },
        {
            "id": "number2",
            "name": "number2",
            "description": "Description: The number to set.",
            "type": "NUMBER"
        },
        {
            "id": "number3",
            "name": "number3",
            "description": "Description: The number to set.",
            "type": "NUMBER"
        },
    ],

    outputs: [
        {
            "id": "text1",
            "name": "Text 1",
            "description": "Type: Text\n\nDescription: The text.",
            "types": ["text"]
        },
        {
            "id": "text2",
            "name": "Text 2",
            "description": "Type: Text\n\nDescription: The text.",
            "types": ["text"]
        },
        {
            "id": "text3",
            "name": "Text 3",
            "description": "Type: Text\n\nDescription: The text.",
            "types": ["text"]
        },
        {
            "id": "text4",
            "name": "Text 4",
            "description": "Type: Text\n\nDescription: The text.",
            "types": ["text"]
        },
        {
            "id": "text5",
            "name": "Text 5",
            "description": "Type: Text\n\nDescription: The text.",
            "types": ["text"]
        },
        {
            "id": "text6",
            "name": "Text 6",
            "description": "Type: Text\n\nDescription: The text.",
            "types": ["text"]
        },
        {
            "id": "number1",
            "name": "number1",
            "description": "Type: Text\n\nDescription: The number.",
            "types": ["number"]
        },
        {
            "id": "number2",
            "name": "number2",
            "description": "Type: Text\n\nDescription: The number.",
            "types": ["number"]
        },
        {
            "id": "number3",
            "name": "number3",
            "description": "Type: Text\n\nDescription: The number.",
            "types": ["number"]
        }
    ],

    code(cache) {
        this.StoreOutputValue(this.GetOptionValue("text1", cache), "text1", cache, "inputBlock");
        this.StoreOutputValue(this.GetOptionValue("text2", cache), "text2", cache, "inputBlock");
        this.StoreOutputValue(this.GetOptionValue("text3", cache), "text3", cache, "inputBlock");
        this.StoreOutputValue(this.GetOptionValue("text4", cache), "text4", cache, "inputBlock");
        this.StoreOutputValue(this.GetOptionValue("text5", cache), "text5", cache, "inputBlock");
        this.StoreOutputValue(this.GetOptionValue("text6", cache), "text6", cache, "inputBlock");
        this.StoreOutputValue(this.GetOptionValue("number1", cache), "number1", cache, "inputBlock");
        this.StoreOutputValue(this.GetOptionValue("number2", cache), "number2", cache, "inputBlock");
        this.StoreOutputValue(this.GetOptionValue("number3", cache), "number3", cache, "inputBlock");
    }
}