import React, { useState, useEffect } from "react";
import axios from "axios";

import PostItem from "../../../components/PostItem/PostItem";
import HeaderComponent from "../../../components/HeaderComponent/HeaderComponent";
import MoveToTopToggle from "../../../components/MoveToTop/MoveToTopToggle.js";

import styles from "./FeedPage.module.css";



function Feed() {
  axios.defaults.baseURL = "http://i8b210.p.ssafy.io:8080";
  // axios.defaults.baseURL = "http://localhost:8080/";
  axios.defaults.withCredentials = false;

  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios
      .get("/post/list?page=1")
      .then((response) => {
        setPosts(response.data.content);
      })
      .catch((error) => {
        console.log("error : " + error);
        console.dir(axios.defaults);
      });
  }, []);

  const postList = posts.map(({ id, writer, weather, regDate, content }) => (
    <PostItem
      key={id}
      postId={id}
      writer={writer}
      weather={weather}
      regDate={regDate}
      content={content}
    ></PostItem>
  ));

  return (
    <div className={styles.feedRoot}>
      <HeaderComponent pageName={"피드"} optType={0}></HeaderComponent>
      <div className={styles.friendListBar}>
        {/** 친구 프로필을 나열한다.  */}
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            alt="test"
            src="images/commentProfileSample.png"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            src="images/commentProfileSample.png"
            alt="test"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            alt="test"
            src="images/commentProfileSample.png"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            alt="test"
            src="images/commentProfileSample.png"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            alt="test"
            src="images/commentProfileSample.png"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            alt="test"
            src="images/commentProfileSample.png"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            alt="test"
            src="images/commentProfileSample.png"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            alt="test"
            src="images/commentProfileSample.png"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            alt="test"
            src="images/commentProfileSample.png"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            alt="test"
            src="images/commentProfileSample.png"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            alt="test"
            src="images/commentProfileSample.png"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            src="images/commentProfileSample.png"
            alt="test"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            src="images/commentProfileSample.png"
            alt="test"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            src="images/commentProfileSample.png"
            alt="test"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            src="images/commentProfileSample.png"
            alt="test"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            src="images/commentProfileSample.png"
            alt="test"
            className={styles.friendProfileImg}
          ></img>
        </div>
        <div className={`${styles.friendThumbnail} ${styles.a}`}>
          <img
            src="images/commentProfileSample.png"
            alt="test"
            className={styles.friendProfileImg}
          ></img>
        </div>
      </div>
      <div className={styles.main}>
        {/** 친구들의 포스트를 나열한다.  */}
        {postList}
      </div>
      <MoveToTopToggle></MoveToTopToggle>
    </div>
  );
}

export default Feed;
