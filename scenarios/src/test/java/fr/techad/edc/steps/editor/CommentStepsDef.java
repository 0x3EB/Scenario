package fr.techad.edc.steps.editor;

import org.junit.Assert;

import cucumber.api.java.en.And;
import fr.techad.edc.pages.editor.documentationTypes.ContextualisedUIHelpComp;
import fr.techad.edc.pages.editor.editorArea.CommentsComp;
import fr.techad.edc.utils.WebDriverFactory;

public class CommentStepsDef {

	ContextualisedUIHelpComp context = new ContextualisedUIHelpComp(WebDriverFactory.getDriver());
	CommentsComp comments = new CommentsComp(WebDriverFactory.getDriver());

	@And("^add a comment \"([^\"]*)\" in \"([^\"]*)\" and post it$")
	public void addACommentInTheChapterAndPostIt(String strComment, String strChapter) throws Throwable {
		context.clickAddComment(strChapter);
		Assert.assertTrue("CAN NOT COMMENT", comments.addComment(strComment));
	}
}
