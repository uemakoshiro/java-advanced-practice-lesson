package jp.co.axiz.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.util.AppUtil;

class AppUtilTest {

	@Test
	public void no1() {
		CardGameApp a = new CardGameApp();
		assertEquals(true, AppUtil.isGameApp(a));
	}
	@Test
	public void no2() {
		DartsGameApp a = new DartsGameApp();
		assertEquals(true, AppUtil.isGameApp(a));
	}
	@Test
	public void no3() {
		ClockApp a = new ClockApp();
		assertEquals(false, AppUtil.isGameApp(a));
	}
	
	
	@Test
	public void no4() {
		CardGameApp a = new CardGameApp();
		assertEquals(true, AppUtil.isCardGameApp(a));
	}
	@Test
	public void no5() {
		DartsGameApp a = new DartsGameApp();
		assertEquals(false, AppUtil.isCardGameApp(a));
	}
	@Test
	public void no6() {
		ClockApp a = new ClockApp();
		assertEquals(false, AppUtil.isCardGameApp(a));
	}
	

	@Test
	public void no7() {
		CardGameApp a = new CardGameApp();
		assertEquals(false, AppUtil.isDartsGameApp(a));
	}
	@Test
	public void no8() {
		DartsGameApp a = new DartsGameApp();
		assertEquals(true, AppUtil.isDartsGameApp(a));
	}
	@Test
	public void no9() {
		ClockApp a = new ClockApp();
		assertEquals(false, AppUtil.isDartsGameApp(a));
	}

	
	@Test
	public void no10() {
		CardGameApp a = new CardGameApp();
		assertEquals(false, AppUtil.isClockApp(a));
	}
	@Test
	public void no11() {
		DartsGameApp a = new DartsGameApp();
		assertEquals(false, AppUtil.isClockApp(a));
	}
	@Test
	public void no12() {
		ClockApp a = new ClockApp();
		assertEquals(true, AppUtil.isClockApp(a));
	}

	
	@Test
	public void no13() {
		CardGameApp a = new CardGameApp();
		assertEquals("ゲーム：カード", AppUtil.getAppName(a));
	}
	@Test
	public void no14() {
		DartsGameApp a = new DartsGameApp();
		assertEquals("ゲーム：ダーツ", AppUtil.getAppName(a));
	}
	@Test
	public void no15() {
		ClockApp a = new ClockApp();
		assertEquals("時計", AppUtil.getAppName(a));
	}

}
