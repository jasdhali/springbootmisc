package appsuite.data.repository.location;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import appsuite.domain.Country;

@Entity
public class CountryLanguage {
	
	@EmbeddedId
	private CountryLangPK countryLangPK;
	
	private  Character 	isOfficial;
	private  Float 		percentage;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "countryCode", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Country country;

	@EmbeddedId
	public CountryLangPK getCountryLangPK() {
		return countryLangPK;
	}
	public void setCountryLangPK(CountryLangPK countryLangPK) {
		this.countryLangPK = countryLangPK;
	}
	public Character getIsOfficial() {
		return isOfficial;
	}
	public void setIsOfficial(Character isOfficial) {
		this.isOfficial = isOfficial;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	} 	
	
}