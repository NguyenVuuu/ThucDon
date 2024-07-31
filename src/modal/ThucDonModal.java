package modal;

import java.util.StringTokenizer;

public class ThucDonModal {
	private String luaChon_monChinh;
	private String luaChon_monPhu;
	private double tongTien;

	public ThucDonModal() {
		this.luaChon_monChinh = "";
		this.luaChon_monPhu = "";
		this.tongTien = 0;
	}

	/**
	 * @return the luaChon_monChinh
	 */
	public String getLuaChon_monChinh() {
		return luaChon_monChinh;
	}

	/**
	 * @param luaChon_monChinh the luaChon_monChinh to set
	 */
	public void setLuaChon_monChinh(String luaChon_monChinh) {
		this.luaChon_monChinh = luaChon_monChinh;
	}

	/**
	 * @return the luaChon_monPhu
	 */
	public String getLuaChon_monPhu() {
		return luaChon_monPhu;
	}

	/**
	 * @param luaChon_monPhu the luaChon_monPhu to set
	 */
	public void setLuaChon_monPhu(String luaChon_monPhu) {
		this.luaChon_monPhu = luaChon_monPhu;
	}

	/**
	 * @return the tongTien
	 */
	public double getTongTien() {
		return tongTien;
	}

	/**
	 * @param tongTien the tongTien to set
	 */
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public void tinhTongTien() {
		this.tongTien = 0;

		if (this.luaChon_monChinh.equals("Cơm Gà")) {
			tongTien += 30000;
		} else if (this.luaChon_monChinh.equals("Mỳ Quảng")) {
			tongTien += 40000;
		} else if (this.luaChon_monChinh.equals("Phở Bò")) {
			tongTien += 50000;
		} else if (this.luaChon_monChinh.equals("Bún Thịt Nướng")) {
			tongTien += 25000;
		} else if (this.luaChon_monChinh.equals("Phở Gà")) {
			tongTien += 45000;
		}

		StringTokenizer stk = new StringTokenizer(this.luaChon_monPhu, ";");
		while (stk.hasMoreElements()) {
			String monPhu = stk.nextToken();
			monPhu = monPhu.trim();
			if (monPhu.equals("Chè Thái")) {
				tongTien += 12000;
			} else if (monPhu.equals("Kem Trái Cây")) {
				tongTien += 15000;
			} else if (monPhu.equals("Bánh Plan")) {
				tongTien += 7000;
			} else if (monPhu.equals("Nước Ngọt")) {
				tongTien += 10000;
			} else if (monPhu.equals("Trà Sữa")) {
				tongTien += 15000;
			} else if (monPhu.equals("Nước Trái Cây")) {
				tongTien += 13000;
			} else if (monPhu.equals("Sinh Tố")) {
				tongTien += 20000;
			} else if (monPhu.equals("Chè Thập Cẩm")) {
				tongTien += 17000;
			}
		}
	}

}
