package com.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

/**
 * The type Movie.
 */
@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie{

	@JsonProperty("Metascore")
	private String metascore;

	@JsonProperty("BoxOffice")
	private String boxOffice;

	@JsonProperty("Website")
	private String website;

	@JsonProperty("imdbRating")
	private String imdbRating;

	@JsonProperty("imdbVotes")
	private String imdbVotes;

	@JsonProperty("Ratings")
	private List<RatingsItem> ratings;

	@JsonProperty("Runtime")
	private String runtime;

	@JsonProperty("Language")
	private String language;

	@JsonProperty("Rated")
	private String rated;

	@JsonProperty("Production")
	private String production;

	@JsonProperty("Released")
	private String released;

	@JsonProperty("imdbID")
	private String imdbID;

	@JsonProperty("Plot")
	private String plot;

	@JsonProperty("Director")
	private String director;

	@JsonProperty("Title")
	private String title;

	@JsonProperty("Actors")
	private String actors;

	@JsonProperty("Response")
	private String response;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("Awards")
	private String awards;

	@JsonProperty("DVD")
	private String dVD;

	@JsonProperty("Year")
	private String year;

	@JsonProperty("Poster")
	private String poster;

	@JsonProperty("Country")
	private String country;

	@JsonProperty("Genre")
	private String genre;

	@JsonProperty("Writer")
	private String writer;

	/**
	 * Set metascore.
	 *
	 * @param metascore the metascore
	 */
	public void setMetascore(String metascore){
		this.metascore = metascore;
	}

	/**
	 * Get metascore string.
	 *
	 * @return the string
	 */
	public String getMetascore(){
		return metascore;
	}

	/**
	 * Set box office.
	 *
	 * @param boxOffice the box office
	 */
	public void setBoxOffice(String boxOffice){
		this.boxOffice = boxOffice;
	}

	/**
	 * Get box office string.
	 *
	 * @return the string
	 */
	public String getBoxOffice(){
		return boxOffice;
	}

	/**
	 * Set website.
	 *
	 * @param website the website
	 */
	public void setWebsite(String website){
		this.website = website;
	}

	/**
	 * Get website string.
	 *
	 * @return the string
	 */
	public String getWebsite(){
		return website;
	}

	/**
	 * Set imdb rating.
	 *
	 * @param imdbRating the imdb rating
	 */
	public void setImdbRating(String imdbRating){
		this.imdbRating = imdbRating;
	}

	/**
	 * Get imdb rating string.
	 *
	 * @return the string
	 */
	public String getImdbRating(){
		return imdbRating;
	}

	/**
	 * Set imdb votes.
	 *
	 * @param imdbVotes the imdb votes
	 */
	public void setImdbVotes(String imdbVotes){
		this.imdbVotes = imdbVotes;
	}

	/**
	 * Get imdb votes string.
	 *
	 * @return the string
	 */
	public String getImdbVotes(){
		return imdbVotes;
	}

	/**
	 * Set ratings.
	 *
	 * @param ratings the ratings
	 */
	public void setRatings(List<RatingsItem> ratings){
		this.ratings = ratings;
	}

	/**
	 * Get ratings list.
	 *
	 * @return the list
	 */
	public List<RatingsItem> getRatings(){
		return ratings;
	}

	/**
	 * Set runtime.
	 *
	 * @param runtime the runtime
	 */
	public void setRuntime(String runtime){
		this.runtime = runtime;
	}

	/**
	 * Get runtime string.
	 *
	 * @return the string
	 */
	public String getRuntime(){
		return runtime;
	}

	/**
	 * Set language.
	 *
	 * @param language the language
	 */
	public void setLanguage(String language){
		this.language = language;
	}

	/**
	 * Get language string.
	 *
	 * @return the string
	 */
	public String getLanguage(){
		return language;
	}

	/**
	 * Set rated.
	 *
	 * @param rated the rated
	 */
	public void setRated(String rated){
		this.rated = rated;
	}

	/**
	 * Get rated string.
	 *
	 * @return the string
	 */
	public String getRated(){
		return rated;
	}

	/**
	 * Set production.
	 *
	 * @param production the production
	 */
	public void setProduction(String production){
		this.production = production;
	}

	/**
	 * Get production string.
	 *
	 * @return the string
	 */
	public String getProduction(){
		return production;
	}

	/**
	 * Set released.
	 *
	 * @param released the released
	 */
	public void setReleased(String released){
		this.released = released;
	}

	/**
	 * Get released string.
	 *
	 * @return the string
	 */
	public String getReleased(){
		return released;
	}

	/**
	 * Set imdb id.
	 *
	 * @param imdbID the imdb id
	 */
	public void setImdbID(String imdbID){
		this.imdbID = imdbID;
	}

	/**
	 * Get imdb id string.
	 *
	 * @return the string
	 */
	public String getImdbID(){
		return imdbID;
	}

	/**
	 * Set plot.
	 *
	 * @param plot the plot
	 */
	public void setPlot(String plot){
		this.plot = plot;
	}

	/**
	 * Get plot string.
	 *
	 * @return the string
	 */
	public String getPlot(){
		return plot;
	}

	/**
	 * Set director.
	 *
	 * @param director the director
	 */
	public void setDirector(String director){
		this.director = director;
	}

	/**
	 * Get director string.
	 *
	 * @return the string
	 */
	public String getDirector(){
		return director;
	}

	/**
	 * Set title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Get title string.
	 *
	 * @return the string
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Set actors.
	 *
	 * @param actors the actors
	 */
	public void setActors(String actors){
		this.actors = actors;
	}

	/**
	 * Get actors string.
	 *
	 * @return the string
	 */
	public String getActors(){
		return actors;
	}

	/**
	 * Set response.
	 *
	 * @param response the response
	 */
	public void setResponse(String response){
		this.response = response;
	}

	/**
	 * Get response string.
	 *
	 * @return the string
	 */
	public String getResponse(){
		return response;
	}

	/**
	 * Set type.
	 *
	 * @param type the type
	 */
	public void setType(String type){
		this.type = type;
	}

	/**
	 * Get type string.
	 *
	 * @return the string
	 */
	public String getType(){
		return type;
	}

	/**
	 * Set awards.
	 *
	 * @param awards the awards
	 */
	public void setAwards(String awards){
		this.awards = awards;
	}

	/**
	 * Get awards string.
	 *
	 * @return the string
	 */
	public String getAwards(){
		return awards;
	}

	/**
	 * Set dvd.
	 *
	 * @param dVD the d vd
	 */
	public void setDVD(String dVD){
		this.dVD = dVD;
	}

	/**
	 * Get dvd string.
	 *
	 * @return the string
	 */
	public String getDVD(){
		return dVD;
	}

	/**
	 * Set year.
	 *
	 * @param year the year
	 */
	public void setYear(String year){
		this.year = year;
	}

	/**
	 * Get year string.
	 *
	 * @return the string
	 */
	public String getYear(){
		return year;
	}

	/**
	 * Set poster.
	 *
	 * @param poster the poster
	 */
	public void setPoster(String poster){
		this.poster = poster;
	}

	/**
	 * Get poster string.
	 *
	 * @return the string
	 */
	public String getPoster(){
		return poster;
	}

	/**
	 * Set country.
	 *
	 * @param country the country
	 */
	public void setCountry(String country){
		this.country = country;
	}

	/**
	 * Get country string.
	 *
	 * @return the string
	 */
	public String getCountry(){
		return country;
	}

	/**
	 * Set genre.
	 *
	 * @param genre the genre
	 */
	public void setGenre(String genre){
		this.genre = genre;
	}

	/**
	 * Get genre string.
	 *
	 * @return the string
	 */
	public String getGenre(){
		return genre;
	}

	/**
	 * Set writer.
	 *
	 * @param writer the writer
	 */
	public void setWriter(String writer){
		this.writer = writer;
	}

	/**
	 * Get writer string.
	 *
	 * @return the string
	 */
	public String getWriter(){
		return writer;
	}

	@Override
 	public String toString(){
		return 
			"Movie{" + 
			"metascore = '" + metascore + '\'' + 
			",boxOffice = '" + boxOffice + '\'' + 
			",website = '" + website + '\'' + 
			",imdbRating = '" + imdbRating + '\'' + 
			",imdbVotes = '" + imdbVotes + '\'' + 
			",ratings = '" + ratings + '\'' + 
			",runtime = '" + runtime + '\'' + 
			",language = '" + language + '\'' + 
			",rated = '" + rated + '\'' + 
			",production = '" + production + '\'' + 
			",released = '" + released + '\'' + 
			",imdbID = '" + imdbID + '\'' + 
			",plot = '" + plot + '\'' + 
			",director = '" + director + '\'' + 
			",title = '" + title + '\'' + 
			",actors = '" + actors + '\'' + 
			",response = '" + response + '\'' + 
			",type = '" + type + '\'' + 
			",awards = '" + awards + '\'' + 
			",dVD = '" + dVD + '\'' + 
			",year = '" + year + '\'' + 
			",poster = '" + poster + '\'' + 
			",country = '" + country + '\'' + 
			",genre = '" + genre + '\'' + 
			",writer = '" + writer + '\'' + 
			"}";
		}
}