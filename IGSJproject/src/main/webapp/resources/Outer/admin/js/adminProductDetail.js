//ck에디터 적용
var myEditor;
ClassicEditor
	.create(document.querySelector('#product_description'), {

		removePlugins: ['Heading'],
		language: "ko"

	})
	.then(editor => {

		// ck에디터 readonly 속성 적용
		const toolbarElement = editor.ui.view.toolbar.element;

		toolbarElement.style.display = 'none';

		editor.enableReadOnlyMode('#product_description');

	})
	.catch(error => {
		console.error(error);
	});