<g:uploadForm name="uploadFeaturedImage" action="uploadFeaturedImage">
    <g:hiddenField name="id" value="${this.subject?.id}" />
    <g:hiddenField name="version" value="${this.subject?.version}" />
    <input type="file" name="featuredImageFile" />
    <field-set class="buttons">
        <input class="save" type="submit" value="${message(code: 'subject.featuredImage.upload.label', default: 'Upload')}" />
    </field-set>
</g:uploadForm>