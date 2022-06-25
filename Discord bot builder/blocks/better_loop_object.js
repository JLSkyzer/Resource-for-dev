module.exports = {
    name: "Better Loop Object",

    description: "Loops the object. For each property in the object, this will return its key and value.",

    category: "Loop Stuff",

    inputs: [
        {
            "id": "action",
            "name": "Action",
            "description": "Acceptable Types: Action\n\nDescription: Executes this block.",
            "types": ["action"]
        },
        {
            "id": "object",
            "name": "Object",
            "description": "Acceptable Types: Object, Unspecified\n\nDescription: The object to loop.",
            "types": ["object", "unspecified"],
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
            "id": "delay",
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
            "description": "Type: Action\n\nDescription: Executes the following blocks for each property in the object.",
            "types": ["action"]
        },
        {
            "id": "action2",
            "name": "Action (Finish)",
            "description": "Type: Action\n\nDescription: Executes the following blocks when this block finishes its task.",
            "types": ["action"]
        },
        {
            "id": "loop",
            "name": "Loop Count",
            "description": "Type: Action\n\nDescription: Counts the amount of loops the block has made.",
            "types": ["number"]
        },
        {
            "id": "key",
            "name": "Key",
            "description": "Type: Text\n\nDescription: The key of the object property.",
            "types": ["text"]
        },
        {
            "id": "value",
            "name": "Value",
            "description": "Type: Unspecified\n\nDescription: The value of the object property.",
            "types": ["unspecified"]
        },
    ],

   async code(cache) {
        const type = this.GetOptionValue("type", cache)
        const object = this.GetInputValue("object", cache);

        const option_time = parseInt(this.GetOptionValue("delay", cache))
        const input_time = this.GetInputValue("delay", cache) || 0;
        let time = isNaN(option_time) ? input_time : option_time

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

        let count = 0
        for (const [key, value] of Object.entries(object)) {

            this.StoreOutputValue(key, "key", cache);
            this.StoreOutputValue(value, "value", cache);
            count++
            this.StoreOutputValue(count, "loop", cache)
            this.RunNextBlock("action", cache);
            await sleep(time)
        }
        this.RunNextBlock("action2", cache)
    }
}