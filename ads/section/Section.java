package jsoft.ads.section;

import jsoft.ShareControl;
import jsoft.library.*;
import jsoft.objects.*;
import java.sql.*;
import org.javatuples.*;

public interface Section extends ShareControl{
	public boolean addSection(SectionObject item);
	public boolean editSection(SectionObject item);
	public boolean delSection(SectionObject item);
	
	public ResultSet getSection(short id);
	public ResultSet getSections(SectionObject similar, int at, byte total);
	
	public ResultSet getSections(SectionObject similar, int at, byte total, SECTION_ORDER so, ORDER o);
	public ResultSet getSections(SectionObject similar, int at, byte total, Pair<SECTION_ORDER, ORDER> order);
}
