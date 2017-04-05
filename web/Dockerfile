FROM nginx:1.11

COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf
RUN mkdir -p /data/www

# COPY ./dist /data/www
VOLUME /data/www

EXPOSE 8080
CMD nginx -g 'daemon off;'