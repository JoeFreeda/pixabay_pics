package com.example.llyods_project.model;

public class HitsItem{
	private int webformatHeight;
	private int imageWidth;
	private int favorites;
	private int previewHeight;
	private String webformatURL;
	private String userImageURL;
	private String previewURL;
	private int comments;
	private String type;
	private int imageHeight;
	private String tags;
	private int previewWidth;
	private int downloads;
	private int userId;
	private String largeImageURL;
	private String pageURL;
	private int id;
	private int imageSize;
	private int webformatWidth;
	private String user;
	private int views;
	private int likes;

	public void setWebformatHeight(int webformatHeight){
		this.webformatHeight = webformatHeight;
	}

	public int getWebformatHeight(){
		return webformatHeight;
	}

	public void setImageWidth(int imageWidth){
		this.imageWidth = imageWidth;
	}

	public int getImageWidth(){
		return imageWidth;
	}

	public void setFavorites(int favorites){
		this.favorites = favorites;
	}

	public int getFavorites(){
		return favorites;
	}

	public void setPreviewHeight(int previewHeight){
		this.previewHeight = previewHeight;
	}

	public int getPreviewHeight(){
		return previewHeight;
	}

	public void setWebformatURL(String webformatURL){
		this.webformatURL = webformatURL;
	}

	public String getWebformatURL(){
		return webformatURL;
	}

	public void setUserImageURL(String userImageURL){
		this.userImageURL = userImageURL;
	}

	public String getUserImageURL(){
		return userImageURL;
	}

	public void setPreviewURL(String previewURL){
		this.previewURL = previewURL;
	}

	public String getPreviewURL(){
		return previewURL;
	}

	public void setComments(int comments){
		this.comments = comments;
	}

	public int getComments(){
		return comments;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setImageHeight(int imageHeight){
		this.imageHeight = imageHeight;
	}

	public int getImageHeight(){
		return imageHeight;
	}

	public void setTags(String tags){
		this.tags = tags;
	}

	public String getTags(){
		return tags;
	}

	public void setPreviewWidth(int previewWidth){
		this.previewWidth = previewWidth;
	}

	public int getPreviewWidth(){
		return previewWidth;
	}

	public void setDownloads(int downloads){
		this.downloads = downloads;
	}

	public int getDownloads(){
		return downloads;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setLargeImageURL(String largeImageURL){
		this.largeImageURL = largeImageURL;
	}

	public String getLargeImageURL(){
		return largeImageURL;
	}

	public void setPageURL(String pageURL){
		this.pageURL = pageURL;
	}

	public String getPageURL(){
		return pageURL;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setImageSize(int imageSize){
		this.imageSize = imageSize;
	}

	public int getImageSize(){
		return imageSize;
	}

	public void setWebformatWidth(int webformatWidth){
		this.webformatWidth = webformatWidth;
	}

	public int getWebformatWidth(){
		return webformatWidth;
	}

	public void setUser(String user){
		this.user = user;
	}

	public String getUser(){
		return user;
	}

	public void setViews(int views){
		this.views = views;
	}

	public int getViews(){
		return views;
	}

	public void setLikes(int likes){
		this.likes = likes;
	}

	public int getLikes(){
		return likes;
	}

	@Override
 	public String toString(){
		return 
			"HitsItem{" + 
			"webformatHeight = '" + webformatHeight + '\'' + 
			",imageWidth = '" + imageWidth + '\'' + 
			",favorites = '" + favorites + '\'' + 
			",previewHeight = '" + previewHeight + '\'' + 
			",webformatURL = '" + webformatURL + '\'' + 
			",userImageURL = '" + userImageURL + '\'' + 
			",previewURL = '" + previewURL + '\'' + 
			",comments = '" + comments + '\'' + 
			",type = '" + type + '\'' + 
			",imageHeight = '" + imageHeight + '\'' + 
			",tags = '" + tags + '\'' + 
			",previewWidth = '" + previewWidth + '\'' + 
			",downloads = '" + downloads + '\'' + 
			",user_id = '" + userId + '\'' + 
			",largeImageURL = '" + largeImageURL + '\'' + 
			",pageURL = '" + pageURL + '\'' + 
			",id = '" + id + '\'' + 
			",imageSize = '" + imageSize + '\'' + 
			",webformatWidth = '" + webformatWidth + '\'' + 
			",user = '" + user + '\'' + 
			",views = '" + views + '\'' + 
			",likes = '" + likes + '\'' + 
			"}";
		}
}
