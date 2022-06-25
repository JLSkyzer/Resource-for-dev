module.exports = {
    name: "Better Loop List",

    description: "Loops the list. For each item in the list, this will return its position number and value. With the added possibility of a delay between each loop",

    category: "Loop Stuff",

    inputs: [
        {
            "id": "action",
            "name": "Action",
            "description": "Acceptable Types: Action\n\nDescription: Executes this block.",
            "types": ["action"]
        },
        {
            "id": "list",
            "name": "List",
            "description": "Acceptable Types: List, Unspecified\n\nDescription: The list to loop.",
            "types": ["list", "unspecified"],
            "required": true
        },
        {
            "id": "delay",
            "name": "Delay",
            "description": "Acceptable Types: Number, Unspecified\n\nDescription: How long to wait between each loop.\n\nIf no number is given here, there will be no delay.",
            "types": ["number", "unspecified"],
        },
    ],

    options: [
        {
            "id": "optiondelay",
            "name": "Loop Delay",
            "description": "Description: How long to wait between each loop.\n\nIf no number is given here, the input delay will be used.",
            "type": "NUMBER"
        },
        {
            "id": "type",
            "name": "Time Unit",
            "description": "Description: Defines what time unit to use for the delay option.",
            "type": "SELECT",
            "options": {
                "ms": "Millisecond",
                "s": "Second",
                "m": "Minute",
                "h": "Hour",
                "d": "Day"
            }   
        }
    ],

    outputs: [
        {
            "id": "action",
            "name": "Action (Loop)",
            "description": "Type: Action\n\nDescription: Executes the following blocks for each item in the list.",
            "types": ["action"]
        },
        {
            "id": "action2",
            "name": "Action (Finish)",
            "description": "Type: Action\n\nDescription: Executes the following blocks for each item in the list.",
            "types": ["action"]
        },
        {
            "id": "index",
            "name": "Position",
            "description": "Type: Number\n\nDescription: The item's position number in the list. Starts at \"0\".",
            "types": ["number", "unspecified"]
        },
        {
            "id": "value",
            "name": "Item Value",
            "description": "Type: Unspecified\n\nDescription: The value of the list item.",
            "types": ["unspecified"]
        }
    ],

    async code(cache) {
        const type = this.GetOptionValue("type", cache)
        const list = this.GetInputValue("list", cache);
   
        const option_time = parseInt(this.GetOptionValue("optiondelay", cache))
        const input_time = parseInt(this.GetInputValue("delay", cache)) || 0

        let time = isNaN(option_time) ?  input_time : option_time 

        switch(type){
            case "ms":
                time = time
                break;
            case "s":
                time = time * 1000
                break;
            case "m":
                time = time * 1000 * 60
                break;
            case "h":
                time = time * 1000 * 60 * 60
                break;
            case "d":
                time = time * 1000 * 60 * 60 * 24
                break;
        }

        const sleep = ms => {
            return new Promise(resolve => setTimeout(resolve, ms))
        }

        for (const [index, value] of Object.entries(list)) {
           this.StoreOutputValue(parseInt(index), "index", cache)

            this.StoreOutputValue(value, "value", cache);
            this.RunNextBlock("action", cache);
            await sleep(time);
        }
        this.RunNextBlock("action2", cache)
    }
}

//function sleep(milliseconds) {
//    const date = Date.now();
//    let currentDate = null;
//    do {
//      currentDate = Date.now();
//    } while (currentDate - date < milliseconds);
//}