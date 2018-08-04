package com.rela.osaka.design.pattern.struct;

// 适配器模式：将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
// 总结：衔接两个不兼容、独立的接口的功能，使得它们能够一起工作。适配器起中介作用。
public class AdapterDemo {
    public static void main(String[] args) {
        Player player = new Player();
        player.play();
    }
}

interface MediaPlayer {
    void play();
}

interface AdvanceMediaPlayer {
    void playVideo();
}

class VideoPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVideo() {
        System.out.println("Play Video!");
    }
}

class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;
    MediaAdapter() {
        advanceMediaPlayer = new VideoPlayer();
    }

    @Override
    public void play() {
        advanceMediaPlayer.playVideo();
    }
}

class Player implements MediaPlayer {
    MediaAdapter mediaAdapter = new MediaAdapter();

    @Override
    public void play() {
        mediaAdapter.play();
    }
}