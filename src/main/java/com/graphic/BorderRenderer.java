import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

public class BorderRenderer implements TableCellRenderer
{
    TableCellRenderer render;
    Border border;
    public BorderRenderer(TableCellRenderer r)
    {
        render = r;
        border = BorderFactory.createMatteBorder(5,5,5,5,Color.green);
	}

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
    												boolean hasFocus, int row, int column)
    {
    	JComponent result = (JComponent)render.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(hasFocus)
        {
        	result.setBorder(border);
        }
        return result;
    }
}
