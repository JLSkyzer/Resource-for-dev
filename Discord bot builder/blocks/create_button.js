module.exports = {
    name: "Create Button",

    description: "Create a message button. This Block is made by @JU & @EXCORDO",

    category: "Component Stuff",
	
    inputs: [
		{
			"id": "action",
            "name": "Action",
            "description": "Type: Action\n\nDescription: Executes this block.",
            "types": ["action"]
		},
        {
            "id": "setStyle",
            "name": "Style",
            "description": "Type: Text\n\nDescription: The Style of the Button. [blurple], [grey], [green], [red], [url]",
            "types": ["text", "unspecified"],
            "required": true
        },
		{
            "id": "setLabel",
            "name": "Label",
            "description": "Type: Text\n\nDescription: The Lable of the Button.",
            "types": ["text", "unspecified"]
        },
		{
		
            "id": "setEmoji",
            "name": "Emoji",
            "description": "Type: Text\n\nDescription: The Emoji of the Button.",
            "types": ["text", "unspecified"]
        },
		{
            "id": "setURL",
            "name": "URL",
            "description": "Type: Text\n\nDescription: The URL of the Button.",
            "types": ["text", "unspecified"]
        },
		{
            "id": "setID",
            "name": "Event-ID",
            "description": "Type: Text\n\nDescription: The ID of the Button (for the Events).",
            "types": ["text", "unspecified"]
        },
		{
            "id": "setDisabled",
            "name": "Disabled",
            "description": "Type: Boolean\n\nDescription: Wheater the Button is disabled (Leave Blank for Enabled).",
            "types": ["boolean"]
        }
    ],

    options: [],

    outputs: [
        {
            "id": "action",
            "name": "Action",
            "description": "Type: Action\n\nDescription: Executes the following blocks when this block finishes its task.",
            "types": ["action"]
        },
        {
            "id": "button",
            "name": "Component",
            "description": "Type: Text\n\nDescription: The Button.",
            "types": ["object"]
        },
    ],

    async code(cache) {
		const { MessageButton } = await this.require('discord-buttons');
		
        let button = new MessageButton();
        ["setStyle", "setLabel", "setEmoji", "setURL", "setID", "setDisabled"].forEach(setting => {
            let toSET = this.GetInputValue(setting, cache);
            if(typeof toSET === "undefined") return

            button[setting](toSET);
        });

        this.StoreOutputValue(button, "button", cache)
        this.RunNextBlock("action", cache);       
    }
}