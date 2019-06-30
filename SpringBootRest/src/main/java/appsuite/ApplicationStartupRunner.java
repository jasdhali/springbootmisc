package appsuite;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import appsuite.data.repository.BookRepository;
import appsuite.data.repository.location.CountryLangPK;
import appsuite.data.repository.location.CountryLanguage;
import appsuite.data.repository.location.CountryLanguageRepository;
import appsuite.data.repository.location.CountryRepository;
import appsuite.domain.Book;
import appsuite.domain.Country;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {
	protected final Log logger = LogFactory.getLog(getClass());

	private BookRepository bookRepository;

	private CountryRepository countryRpository;
	
	private CountryLanguageRepository countryLanguageRepository;

	public ApplicationStartupRunner(
			BookRepository bookRepository,
			CountryRepository countryRpository,
			CountryLanguageRepository countryLanguageRepository) {
		super();
		this.bookRepository = bookRepository;
		this.countryRpository = countryRpository;
		this.countryLanguageRepository = countryLanguageRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Iterable<Book> iterable = bookRepository.findByName("JSF in Action");
		for (Book album : iterable) {
			System.out.println(">>>>>>album Id>> " + album.getAuthor());
		}
		logger.info("ApplicationStartupRunner run method Started !!");
		
		List<Country> countryList = countryRpository.findByAreaRange(4000.1f, 10000.1f);
		for (Country count : countryList) {
			System.out.println(">>>>>>album Id>> " + count.getCode() );
		}
		
		List<Country> countryListByHeadLike = countryRpository.findByHeadNamePattern("Bush");
		for (Country count : countryListByHeadLike) {
			System.out.println(">>>>>>album Id>> " + count.getCode() + " - " + count.getName());
		}
		displayCountryLanguage("AUS" , "Arabic");
	}
	
	private void displayCountryLanguage(String countCode,String language) {
		CountryLangPK countryLangPK = new CountryLangPK();
		
		countryLangPK.setCountryCode(countCode);
		countryLangPK.setLanguage(language);
		
		CountryLanguage countryLanguage = new CountryLanguage();
		countryLanguage.setCountryLangPK(countryLangPK);
		countryLangPK.setCountryCode(countCode);
		countryLangPK.setLanguage(language);
		Example<CountryLanguage> countLangEx = Example.of(countryLanguage); 
		
		CountryLanguage countryLang = countryLanguageRepository.findOne( countLangEx );
		System.out.println(">>>>>>album Id>> " + countryLang.getCountryLangPK().getCountryCode() + " - " 
					+ countryLang.getCountryLangPK().getLanguage());
	}
}