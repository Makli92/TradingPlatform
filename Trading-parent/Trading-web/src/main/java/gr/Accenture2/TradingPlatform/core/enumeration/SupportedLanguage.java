package gr.Accenture2.TradingPlatform.core.enumeration;

import java.util.Locale;

/**
 * The Enum Language represents all supported locales.
 */
public enum SupportedLanguage {
	/** The el. */
	GREEK("el", new Locale("el"), new Locale("el", "GR"));

	/** The code. */
	private String code;

	/** The locale. */
	private Locale locale;

	/**
	 * The regional locale which supports country too.
	 */
	private Locale regionalLocale;

	/**
	 * Instantiates a new {@link SupportedLanguage}.
	 * 
	 * @param code
	 *            the code
	 * @param locale
	 *            the locale
	 */
	private SupportedLanguage(final String code, final Locale locale, final Locale regionalLocale) {
		this.code = code;
		this.locale = locale;
		this.regionalLocale = regionalLocale;
	}

	/**
	 * Gets the code of current {@link SupportedLanguage}.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Gets the locale of current {@link SupportedLanguage}.
	 * 
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Gets the regional locale.
	 * 
	 * @return the regional locale
	 */
	public Locale getRegionalLocale() {
		return regionalLocale;
	}

	/**
	 * Gets the {@link SupportedLanguage} from it's code or the default language if the code does not correspond to any {@link SupportedLanguage}.
	 * 
	 * @param code
	 *            the code
	 * @return the associated {@link SupportedLanguage}
	 */
	public static SupportedLanguage get(final String code) {
		for (final SupportedLanguage e : SupportedLanguage.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return getDefault();
	}

	/**
	 * Gets the default language which in our case is Greek.
	 * 
	 * @return the default language
	 */
	public static SupportedLanguage getDefault() {
		return SupportedLanguage.GREEK;

	}
}
