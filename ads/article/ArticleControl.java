package jsoft.ads.article;

import java.sql.ResultSet;
import java.util.*;
import org.javatuples.*;
import jsoft.*;
import jsoft.objects.*;

public class ArticleControl {

	private ArticleModel am;

	public ArticleControl(ConnectionPool cp) {
		this.am = new ArticleModel(cp);
	}

	protected void finallize() throws Throwable {
		this.am = null;
	}

	
	
	// **********************************************************************
	public boolean addArticleObject(ArticleObject item) {
		return this.am.addArticle(item);
	}

	public boolean editArticleObject(ArticleObject item) {
		return this.am.editArticle(item);
	}

	public boolean delArticleObject(ArticleObject item) {
		return this.am.delArticle(item);
	}
	// ************************************************************************
	
	
	// ************************************************************************
	public ArticleObject getArticleObject(short id) {
		return this.am.getArticleObject(id);
	}
	
	// ************************************************************************
	
	public Pair<String, String> viewArticles (Triplet<ArticleObject, Short, Byte> infos){
		ArrayList<ArticleObject> items = this.am.getArticleObjects(infos.getValue0(), infos.getValue1(), infos.getValue2());
		
		return ArticleLibrary.viewArticles(items);
	}
	
	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		
		ArticleControl ac = new ArticleControl(cp);
		
		Triplet<ArticleObject, Short, Byte> infos = new Triplet<>(null, (short)1, (byte)10);
		
		Pair<String, String> view = ac.viewArticles(infos);
		
		System.out.println(view.getValue0());
	}
}
