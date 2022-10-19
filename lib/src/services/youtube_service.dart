import 'dart:convert';

import 'package:dio/dio.dart';

import 'package:bibliafree/src/models/youtube_channel.dart';
import 'package:bibliafree/src/models/youtube_video.dart';
import 'package:bibliafree/src/providers/youtube_fetch_channel_future_provider.dart';
import 'package:bibliafree/src/services/sunday_mass_service.dart';

class YouTubeService {
  YouTubeService(this._dio);

  final Dio _dio;

  final String _baseUrl = 'www.googleapis.com';
  String _nextPageToken = '';

  Future<YouTubeChannel> fetchChannel(String channelId) async {
    final Map<String, String> parameters = {
      'part': 'snippet, contentDetails, statistics',
      'id': channelId,
      'key': 'AIzaSyBCQKsGQxoZixDIBhpl4YYYN89eySpgRqk',
    };

    Uri uri = Uri.https(_baseUrl, '/youtube/v3/channels', parameters);

    final response = await _dio.getUri(uri);

    if (response.statusCode == 200) {
      Map<String, dynamic> data = response.data['items'][0];
      var channel = YouTubeChannel.fromMap(data);

      // Fetch first batch of videos from uploads playlist
      channel.videos = await fetchVideosFromPlaylist(channel.uploadPlaylistId);

      return channel;
    } else {
      throw json.decode(response.data)['error']['message'];
    }
  }

  Future<List<YouTubeVideo>> fetchVideosFromPlaylist(String playlistId) async {
    Map<String, String> parameters = {
      'part': 'snippet',
      'playlistId': playlistId,
      'maxResults': '8',
      'pageToken': _nextPageToken,
      'key': 'AIzaSyBCQKsGQxoZixDIBhpl4YYYN89eySpgRqk',
    };

    final uri = Uri.https(_baseUrl, '/youtube/v3/playlistItems', parameters);

    // Get Playlist Videos
    final response = await _dio.getUri(uri);

    if (response.statusCode == 200) {
      var data = response.data;

      _nextPageToken = '';
      List<dynamic> videosJson = data['items'];

      // Fetch first eight videos from uploads playlist
      var videos = <YouTubeVideo>[];

      for (var json in videosJson) {
        videos.add(YouTubeVideo.fromMap(json['snippet']));
      }

      return videos;
    } else {
      throw json.decode(response.data)['error']['message'];
    }
  }

  Future<List<dynamic>> fetchLatestChurchVideoId() async {
    final channel = await fetchChannel(YOUTUBE_CHANNEL_ID);

    final list = SundayMassService().getChurchYouTubeChannelIds;

    if (list[0] == channel.id) {
      return [channel.videos!.where((element) => element.title.contains('The Sunday Mass')).toList()[0].id, channel];
    } else if (list[1] == channel.id) {
      return [channel.videos![0].id, channel];
    } else if (list[2] == channel.id) {
      return [
        channel.videos!.where((element) => element.title.contains('Cornerstone Church LIVE')).toList()[0].id,
        channel,
      ];
    } else if (list[3] == channel.id) {
      return [
        channel.videos!
            .where((element) => element.title.contains('Catholic Mass Today | Daily TV Mass'))
            .toList()[0]
            .id,
        channel,
      ];
    } else {
      return ['', channel];
    }
  }
}
