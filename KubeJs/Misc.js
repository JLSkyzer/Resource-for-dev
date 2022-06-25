// Some exemple for item information
onEvent('item.right_click', event => {

	// Get the item that was right clicked
	const item = event.getItem()
	const number = event.item.count

	if (item == 'minecraft:diamond_ore') {
		// send message
		event.server.tell([ 'You found ' + number + ' diamond!' ])
	}
})