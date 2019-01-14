package supermarket.ItemList;

import supermarket.department.BookDepartment;
import supermarket.department.MusicDepartment;
import supermarket.department.SoftwareDepartment;
import supermarket.department.VideoDepartment;

public interface Visitor {
    public void visit(BookDepartment bookDepartment);
    public void visit(MusicDepartment musicDepartment);
    public void visit(SoftwareDepartment softwareDepartment);
    public void visit(VideoDepartment videoDepartment);
}
