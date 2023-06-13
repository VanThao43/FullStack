package jsoft.ads.section;

import jsoft.*;
import jsoft.library.ORDER;
import jsoft.objects.*;
import java.util.*;
import org.javatuples.*;

public class SectionControl {

	private SectionModel sm;

	public SectionControl(ConnectionPool cp) {
		this.sm = new SectionModel(cp);
	}

	protected void finallize() throws Throwable {
		this.sm = null;
	}
	
	
	public ConnectionPool getCP() {
		return this.sm.getCP();
	}
	
	public void releaseConnection() {
		this.sm.releaseConnection();
	}
	

	// **************************************************************************
	public boolean addSection(SectionObject item) {
		return this.sm.addSection(item);
	}

	public boolean editSection(SectionObject item) {
		return this.sm.editSection(item);
	}

	public boolean delSection(SectionObject item) {
		return this.sm.delSection(item);
	}
	// ***************************************************************************

	
	
	// ***************************************************************************

	public SectionObject getSectionObject(short id) {
		return this.sm.getSectionObject(id);
	}

	// ***************************************************************************

	
	
	public Pair<String, String> viewSections(Triplet<SectionObject, Short, Byte> infos, Pair<SECTION_ORDER, ORDER> order) {
		ArrayList<SectionObject> items = this.sm.getSectionObjects(infos.getValue0(), infos.getValue1(),
				infos.getValue2(), order.getValue0(), order.getValue1());

		return SectionLibrary.viewSections(items);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();

		SectionControl sc = new SectionControl(cp);

		Triplet<SectionObject, Short, Byte> infos = new Triplet<>(null, (short) 1, (byte) 15);
		Pair<SECTION_ORDER, ORDER> order = new Pair<SECTION_ORDER, ORDER>(SECTION_ORDER.ID, ORDER.ASC);

		Pair<String, String> view = sc.viewSections(infos, order);
		
		sc.releaseConnection();

		System.out.println(view.getValue0());
	}
}
