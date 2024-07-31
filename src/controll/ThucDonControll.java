package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import view.ThucDonView;

public class ThucDonControll implements ActionListener {

	private ThucDonView thucDonView;

	public ThucDonControll(ThucDonView thucDonView) {
		this.thucDonView = thucDonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// xem người ta chọn món gì
		String monChinh = thucDonView.jComboBox_monChinh.getSelectedItem().toString();

		String monPhu = "";
		Object[] luaChon_monPhu = thucDonView.jList_monPhu.getSelectedValues();
		for (Object o : luaChon_monPhu) {
			// khách chọn gì thì lôi nó ra
			monPhu = monPhu + o.toString() + "; ";
		}

		thucDonView.thucDonModal.setLuaChon_monChinh(monChinh);
		thucDonView.thucDonModal.setLuaChon_monPhu(monPhu);

		thucDonView.thucDonModal.tinhTongTien();

		thucDonView.hienThiKetQua();

//		 phần thối tiền cho khách
		String soTien_chuoi = JOptionPane.showInputDialog(thucDonView,
				thucDonView.jLabel_thongTin.getText() + "\nNhập vào số tiền: ", " Thông báo",
				JOptionPane.PLAIN_MESSAGE);

		// nếu không nhập vào số thì sẽ báo lỗi
		try {
			double soTien = Double.valueOf(soTien_chuoi);
			double soTienNhan = Double.valueOf(soTien_chuoi);
			double soTienThoi = soTienNhan - thucDonView.thucDonModal.getTongTien();
			if (soTienThoi < 0) {
				JOptionPane.showMessageDialog(thucDonView, "Thiếu Tiền!", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(thucDonView,
						"Số Tiền Phải Thối Lại Cho Khách: " + (soTien - thucDonView.thucDonModal.getTongTien()),
						"Thông Báo", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e2) {
			// code báo lỗi
			JOptionPane.showMessageDialog(thucDonView, "Nhập dữ liệu sai!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
