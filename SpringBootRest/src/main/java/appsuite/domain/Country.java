package appsuite.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import appsuite.data.repository.location.CountryLanguage;
import lombok.Data;

@Data
@Entity
public class Country implements Serializable {

	@Id
	private String code;
	private String name;
	private String continent;
	private String region;
	@Column(name = "SurfaceArea")
	private Float surfaceArea;
	@Column(name = "IndepYear")
	private Integer indepYear;

	private Long population;
	@Column(name = "LifeExpectancy")
	private Float lifeExpectancy;
	private Float gNP;
	@Column(name = "GNPOld")
	private Float gNPOld;
	@Column(name = "LocalName")
	private String localName;
	@Column(name = "GovernmentForm")
	private String GovernmentForm;
	@Column(name = "HeadOfState")
	private String HeadOfState;
	private Integer Capital;
	private String Code2;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
	private Set<CountryLanguage> languages;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Set<CountryLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<CountryLanguage> languages) {
		this.languages = languages;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Integer getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(Integer indepYear) {
		this.indepYear = indepYear;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public Float getgNP() {
		return gNP;
	}

	public void setgNP(Float gNP) {
		this.gNP = gNP;
	}

	public Float getgNPOld() {
		return gNPOld;
	}

	public void setgNPOld(Float gNPOld) {
		this.gNPOld = gNPOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return GovernmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		GovernmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return HeadOfState;
	}

	public void setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
	}

	public Integer getCapital() {
		return Capital;
	}

	public void setCapital(Integer capital) {
		Capital = capital;
	}

	public String getCode2() {
		return Code2;
	}

	public void setCode2(String code2) {
		Code2 = code2;
	}

}
