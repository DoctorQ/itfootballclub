(function(e) {
	var f = AC.Storage.getItem;
	var a = AC.Storage.setItem;
	var c = AC.Environment.Browser.name;
	var b = AC.Environment.Browser.version;
	var d = {
		colors : [ "blue", "yellow", "pink", "green", "white" ],
		colorIndexKey : "home-gallery-colors-20130827",
		skinAttribute : "data-skin",
		skinsByColor : [ "dark", "black", "dark", "black", "black" ],
		contentSelector : "#hero .gallery-content",
		minSlideWidth : 1355,
		heroGalleryOptions : {
			continuous : true,
			useTouchEvents : true,
			duration : 1,
			useKeyboardNav : true,
			alwaysUseKeyboardNav : true,
			heightFromFirstSection : false,
			silentTriggers : true
		},
		heroSlideShowOptions : {
			autoplay : false,
			delay : 7000,
			stopOnUserInteraction : true
		},
		init : function() {
			if ("ontouchstart" in window && c === "Safari Mobile" && b === 7) {
				window.scrollTo(0, 0)
			}
			this.wrapper = AC.Element.select("#billboard");
			this.galleryView = AC.Element.select("#hero");
			this.navContainer = AC.Element.select(".nav");
			this.colorSlide = AC.Element.select(".iphone-5c");
			this.galleryContent = AC.Element.selectAll(this.contentSelector);
			this.updateVariableSlideStyles(this.galleryContent.length);
			this.heroGallery = this.createHeroGallery(this.galleryContent,
					this.heroGalleryOptions);
			this.heroSlideShow = this
					.createHeroSlideShow(this.heroSlideShowOptions);
			this.dotNavUsed = false;
			this.minDimensions = this.calcMinDimensions();
			this.addEvents();
			this.initColors();
			this.initTracking();
			this.setupFluidGallery();
			this.heroSlideShow.pause();
			this.setupInlineVideoDeepLink();
			this.setupFlexBox()
		},
		updateVariableSlideStyles : function(i) {
			var h = (100 / i) + "%";
			var g = i * this.minSlideWidth + "px";
			[].forEach.call(this.galleryContent, function(j) {
				AC.Element.setStyle(j, {
					width : h
				})
			});
			AC.Element.setStyle(this.galleryView, {
				minWidth : g
			})
		},
		setupFlexBox : function() {
			var h = AC.Environment.Feature.cssPropertyAvailable;
			var g = h("flex") && !("ontouchstart" in window);
			if (g) {
				AC.Element.addClassName(this.wrapper, "flexible")
			}
		},
		initColors : function() {
			var h = AC.Storage.getItem(this.colorIndexKey) || 0;
			var g = h % this.colors.length;
			this.setColor(this.colors[g]);
			AC.Storage.setItem(this.colorIndexKey, g + 1)
		},
		initTracking : function() {
			if (typeof AC.ViewMaster.Tracker === "function") {
				window.tracker = new AC.ViewMaster.Tracker("click")
			}
		},
		calcMinDimensions : function() {
			var g = AC.Element.selectAll(".gallery-content-wrapper");
			var h = AC.Element.getStyle(g[0], "minHeight");
			h = (h) ? parseInt(h, 10) : 0;
			return {
				width : this.minSlideWidth,
				height : h
			}
		},
		addEvents : function() {
			AC.Element.addEventListener(document, "click", this.handleClick
					.bind(this), false);
			AC.Element.addEventListener(window, "load", function() {
				this.heroSlideShow.start()
			}.bind(this))
		},
		swapIfNecessary : function() {
			var h = AC.Element.selectAll(this.contentSelector);
			var j = AC.Element.select(".dots", this.navContainer);
			var k = AC.Element.selectAll(".dot", j);
			var g = this.galleryView;
			var i = this.visitsIndex % 2;
			if (i) {
				this.galleryView.insertBefore(h[1], h[0]);
				j.insertBefore(k[1], k[0])
			}
		},
		setColor : function(g) {
			[].forEach.call(this.colors, function(h) {
				AC.Element.removeClassName(this.colorSlide, h)
			}.bind(this));
			AC.Element.addClassName(this.colorSlide, g)
		},
		updateSkin : function(i, h) {
			var l = this.wrapper;
			var k;
			if (i === this.colorSlide) {
				var j = AC.Storage.getItem(this.colorIndexKey);
				var g = (h) ? j % this.colors.length : (j - 1)
						% this.colors.length;
				k = this.skinsByColor[g]
			} else {
				k = i.getAttribute(this.skinAttribute)
			}
			this._navSkins.forEach(function(m) {
				AC.Element.removeClassName(l, m)
			});
			AC.Element.addClassName(l, k)
		},
		stashSkins : function() {
			var g = AC.Element.selectAll(this.contentSelector);
			this._navSkins = g.map(function(h) {
				return h.getAttribute(this.skinAttribute)
			}.bind(this))
		},
		lastToFirst : function(l, h, g) {
			var j = l.length;
			var k = l[0];
			var i = l[j - 1];
			return h.id === i.key && g.id === k.key
		},
		swapColors : function() {
			var g;
			var h = AC.Storage.getItem(this.colorIndexKey);
			g = h % this.colors.length;
			this.setColor(this.colors[g]);
			AC.Storage.setItem(this.colorIndexKey, h + 1)
		},
		blurPaddles : function() {
			var g = AC.Element.selectAll(".arrow", this.navContainer);
			g.forEach(function(h) {
				h.blur()
			})
		},
		createHeroGallery : function(i, h) {
			var j = this.galleryView.id;
			var g = new AC.ViewMaster.SlideViewer(i, j, j, h);
			AC.Element.addClassName(this.galleryView, "slides"
					+ g.orderedSections.length);
			this.stashSkins();
			g.setDelegate({
				willShow : function(l, m, k) {
					this.updateSkin(k.content)
				}.bind(this),
				didShow : function(l, m, k) {
					if (m && m.content === this.colorSlide) {
						this.swapColors();
						this.blurPaddles()
					}
				}.bind(this)
			});
			this
					.updateSkin(AC.Element.selectAll(this.contentSelector)[0],
							true);
			return g
		},
		createHeroSlideShow : function(g) {
			return new AC.ViewMaster.Slideshow(this.heroGallery, null, g)
		},
		createWrapperGallery : function() {
			var g = AC.Element.selectAll(".gallery-content-wrapper");
			var k = new AC.ViewMaster.Viewer(
					g,
					"gallery-wrapper",
					"gallery-wrapper-triggers",
					{
						silentTriggers : true,
						escapeToClose : true,
						shouldAnimateContentChange : !(AC.Environment.Browser.name === "IE")
					});
			var i = this.minDimensions;
			var j = AC.Element.select("#homefooter").clientHeight;
			var h = AC.Element.selectAll(".gallery-content .scrim .blur");
			k
					.setDelegate({
						willShow : function(n, p, m) {
							var l = document.viewport.getDimensions();
							var o = AC.Element.select(".gallery-wrapper");
							var q = (l.height > i.height) ? l.height : i.height;
							q = q - j;
							AC.Element.setStyle(o, {
								height : q + "px"
							});
							if (p
									&& p.id === "gallery-content-wrapper-billboard") {
								AC.Element.addClassName(p.content,
										".resize-mask")
							}
						},
						didShow : function(m, o, l) {
							if (o
									&& l.id === "gallery-content-wrapper-billboard") {
								var n = AC.Element.select(".gallery-wrapper");
								AC.Element.setStyle(n, {
									height : ""
								});
								AC.Element.removeClassName(o.content,
										".resize-mask");
								for ( var p = fluidFigures.length - 1; p >= 0; p--) {
									if (AC.Element.hasClassName(
											fluidFigures[p].figure, "active")) {
										var q = fluidFigures[p]
												.getBoundingDimensions(document.viewport
														.getDimensions().height);
										fluidFigures[p].resize(q);
										break
									}
								}
							}
						}
					});
			return k
		},
		setupFluidGallery : function() {
			var h = [];
			var g = new FluidGallery(this.heroGallery, h, 1.17, {},
					this.heroSlideShow, this.minDimensions);
			return g
		},
		handleClick : function(g) {
			var h = AC.Element.select(".nav");
			var m = AC.Event.target(g);
			var l = AC.Element.select('a[href*="#see-all"]', h);
			var j = AC.Element.select('a[href*="#close"]', h);
			var k = AC.Element.hasClassName(m.parentNode, "dot");
			if (AC.Element.hasClassName(m, "gallery-video")) {
				g.stop();
				var i = m.getAttribute("data-uri");
				wrapperViewer.show(wrapperViewer.sectionWithId(i))
			}
			if (k) {
				this.dotNavUsed = true
			}
		},
		setupInlineVideoDeepLink : function() {
			var h = AC.Element.select("a.gallery-video");
			var g = document.location.hash.replace("#", "");
			if (h && g === h.getAttribute("data-uri")) {
				wrapperViewer.show(wrapperViewer.sectionWithId(g))
			}
		}
	};
	window.homepageGallery = d;
	d.init()
})();