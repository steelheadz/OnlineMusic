<script setup lang="ts">
import {baseURL} from "@/api/request";
import type {Singer} from "@/pojo/Singer.ts";

const props = defineProps<{
  playList: Array<Singer>
}>();


const emits = defineEmits<{
  click: [idx: number]
}>();


</script>

<template>
  <div class="play-list">
    <!--    <div class="play-title" v-if="title">{{ title }}</div>-->
    <ul class="play-body">
      <li class="card-frame" v-for="(item,idx) in props.playList" :key="item.id" @click="emits('click',idx)">
        <div class="card" :title="item.introduction">
          <el-image class="card-img" fit="contain" loading="lazy" :src="baseURL + item.pic"/>
        </div>
        <p class="card-name">{{ item.name || item.title }}</p>
      </li>
    </ul>
  </div>
</template>

<style scoped lang="scss">
.play-list {
  padding: 0 1rem;

  .play-title {
    height: 60px;
    line-height: 60px;
    font-size: 28px;
    font-weight: 500;
    text-align: center;
    color: black;
    box-sizing: border-box;
  }

  .play-body {
    display: flex;
    // 让项目换行
    flex-wrap: wrap;
  }
}

.card-frame {
  display: inline-block;
  //display: unset;
  .card {
    position: relative;
    height: 0;
    padding-bottom: 100%;
    overflow: hidden;
    border-radius: 5px;

    .card-img {
      width: 100%;
      transition: all 0.4s ease;
    }
  }

  .card-name {
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    margin: 0.5rem 0;
  }

  &:hover .card-img {
    transform: scale(1.2);
  }
}

.mask {
  position: absolute;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
  border-radius: 5px;
  background-color: rgba(52, 47, 41, 0.4);
  //@include layout(center, center);
  transition: all 0.3s ease-in-out;
  opacity: 0;

  .mask-icon {
    //@include icon(2em, rgba(240, 240, 240, 1));
  }

  &:hover {
    opacity: 1;
    cursor: pointer;
  }
}

@media screen and (min-width: 668px) {
  .card-frame {
    width: 18%;
    margin: 0.5rem 1%;
  }
}

@media screen and (max-width: 668px) {
  .card-frame {
    width: 46%;
    margin: 0.5rem 2%;
  }
}
</style>