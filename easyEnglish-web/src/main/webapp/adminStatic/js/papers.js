function goPage(pager) {
	$("#data").load(pager);
	history.pushState(null, null, pager);
}

