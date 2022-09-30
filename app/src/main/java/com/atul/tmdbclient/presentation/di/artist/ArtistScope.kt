package com.atul.tmdbclient.presentation.di.artist

import javax.inject.Scope

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
//@kotlin  - k is small
annotation class ArtistScope

//We don't need it's body.
//Add this scope in ArtistModule as scope.