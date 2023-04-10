package jsoft.ads.article;

import jsoft.library.*;
import jsoft.objects.*;
import java.sql.*;
import org.javatuples.*;

public interface Article {
	public boolean addArticle(ArticleObject item);
	public boolean editArticle(ArticleObject item);
	public boolean delArticle(ArticleObject item);
	
	public ResultSet getArticle(int id);
	public ResultSet getArticles(ArticleObject similar, int at, byte total);
	
	public ResultSet getArticles(ArticleObject similar, int at, byte total, ARTICLE_ORDER aro, ORDER o);
	public ResultSet getArticles(ArticleObject similar, int at, byte total, Pair<ARTICLE_ORDER, ORDER> order);
}
